package com.codehive.restaurantsservice.restaurants.application.services;

import com.codehive.restaurantsservice.restaurants.application.ports.inputs.IMessageBrokerServicePort;
import com.codehive.restaurantsservice.restaurants.application.ports.outputs.IMessageBrokerPersistencePort;
import com.codehive.restaurantsservice.restaurants.domain.models.MealModel;
import com.codehive.restaurantsservice.restaurants.domain.models.RestaurantModel;
import com.codehive.restaurantsservice.shared.domain.SagaMessageModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class MessageBrokerServiceImpl implements IMessageBrokerServicePort {

    private final IMessageBrokerPersistencePort messageBrokerPersistencePort;
    private final MealServiceImpl mealService;
    private final RestaurantServiceImpl restaurantService;
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public MessageBrokerServiceImpl(IMessageBrokerPersistencePort messageBrokerPersistencePort, MealServiceImpl mealService, RestaurantServiceImpl restaurantService, RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.messageBrokerPersistencePort = messageBrokerPersistencePort;
        this.mealService = mealService;
        this.restaurantService = restaurantService;
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void publishMessage(String message, String routingKey) {
        try {
            String jsonMessage = objectMapper.writeValueAsString(message);
            rabbitTemplate.convertAndSend(routingKey, jsonMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing message", e);
        }
    }

    @Override
    public void consumeMessage(MessageConsumer callback, String routingKey) {
        messageBrokerPersistencePort.consumeMessage((message) -> {
            try {
                UUID uuid = UUID.fromString(String.valueOf(message));
                MealModel meal = mealService.get(uuid);

                if (meal != null) {

                    RestaurantModel restaurant = restaurantService.getRestaurantByMealId(uuid);
                    if (restaurant != null) {

                        SagaMessageModel sagaMessage = new SagaMessageModel();
                        sagaMessage.setUuid(uuid.toString());
                        sagaMessage.setSuccess(true);
                        Map<String, Object> data = new HashMap<>();
                        data.put("meal", meal);
                        data.put("restaurant", restaurant);
                        sagaMessage.setData(data);


                        String jsonMessage = new ObjectMapper().writeValueAsString(sagaMessage);
                        String newRoutingKey = "Nombre de la cola";
                        publishMessage(jsonMessage, newRoutingKey);
                    } else {
                        System.out.println("Restaurant not found for Meal with UUID: " + uuid);
                    }
                } else {
                    System.out.println("No Meal found with UUID: " + uuid);
                }
            } catch (IllegalArgumentException | JsonProcessingException e) {
                System.out.println("Error processing message: " + message + " - " + e.getMessage());
            }
        }, routingKey);
    }


}

package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance;

import com.codehive.restaurantsservice.restaurants.application.ports.outputs.IMessageBrokerPersistencePort;
import org.springframework.stereotype.Component;

@Component
public class MessageBrokerPersistenceAdapter implements IMessageBrokerPersistencePort {
    @Override
    public void publishMessage(String message, String routingKey) {

    }

    @Override
    public void consumeMessage(MessageConsumer callback, String routingKey) {

    }
}

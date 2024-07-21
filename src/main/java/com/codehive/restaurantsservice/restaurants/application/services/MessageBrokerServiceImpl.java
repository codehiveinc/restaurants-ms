package com.codehive.restaurantsservice.restaurants.application.services;

import com.codehive.restaurantsservice.restaurants.application.ports.inputs.IMessageBrokerServicePort;
import com.codehive.restaurantsservice.restaurants.application.ports.outputs.IMessageBrokerPersistencePort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MessageBrokerServiceImpl implements IMessageBrokerServicePort {

    private final IMessageBrokerPersistencePort messageBrokerPersistencePort;

    public MessageBrokerServiceImpl(IMessageBrokerPersistencePort messageBrokerPersistencePort) {
        this.messageBrokerPersistencePort = messageBrokerPersistencePort;
    }

    @Override
    public void publishMessage(String message, String routingKey) {
        messageBrokerPersistencePort.publishMessage(message, routingKey);
    }

    @Override
    public void consumeMessage(MessageConsumer callback, String routingKey) {
        messageBrokerPersistencePort.consumeMessage((IMessageBrokerPersistencePort.MessageConsumer) callback, routingKey);
    }
}

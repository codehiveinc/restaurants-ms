package com.codehive.restaurantsservice.restaurants.application.ports.outputs;


import com.codehive.restaurantsservice.shared.domain.SagaMessageModel;

public interface IMessageBrokerPersistencePort {

    void publishMessage(String message, String routingKey);

    void consumeMessage(MessageConsumer callback, String routingKey);

    @FunctionalInterface
    interface MessageConsumer {
        void accept(SagaMessageModel message);
    }

}

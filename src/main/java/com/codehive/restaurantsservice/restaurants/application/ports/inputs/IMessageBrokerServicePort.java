package com.codehive.restaurantsservice.restaurants.application.ports.inputs;

public interface IMessageBrokerServicePort {

    void publishMessage(String message, String routingKey);

    void consumeMessage(MessageConsumer callback, String routingKey);

    @FunctionalInterface
    interface MessageConsumer {
        void accept(String message);
    }


}

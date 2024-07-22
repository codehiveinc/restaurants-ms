package com.codehive.restaurantsservice.restaurants.infrastructure.exceptions;

public class RestaurantNotFoundException extends RuntimeException{
    public RestaurantNotFoundException(String message) {
        super(message);
    }
}

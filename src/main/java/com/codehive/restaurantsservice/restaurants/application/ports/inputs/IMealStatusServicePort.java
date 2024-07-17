package com.codehive.restaurantsservice.restaurants.application.ports.inputs;

import com.codehive.restaurantsservice.restaurants.domain.models.MealStatusModel;

import java.util.UUID;

public interface IMealStatusServicePort {

    MealStatusModel get (UUID uuid);
}

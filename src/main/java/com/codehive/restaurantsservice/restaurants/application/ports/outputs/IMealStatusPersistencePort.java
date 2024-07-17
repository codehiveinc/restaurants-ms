package com.codehive.restaurantsservice.restaurants.application.ports.outputs;

import com.codehive.restaurantsservice.restaurants.domain.models.MealStatusModel;

import java.util.UUID;

public interface IMealStatusPersistencePort {

    MealStatusModel get (UUID uuid);
}

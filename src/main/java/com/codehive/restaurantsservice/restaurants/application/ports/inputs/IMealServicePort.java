package com.codehive.restaurantsservice.restaurants.application.ports.inputs;

import com.codehive.restaurantsservice.restaurants.domain.models.MealModel;

import java.util.List;
import java.util.UUID;

public interface IMealServicePort {

    MealModel create(MealModel mealModel);

    MealModel get(UUID uuid);

    List<MealModel> list();

    MealModel update(UUID uuid, MealModel mealModel);

    void delete(UUID uuid);
}

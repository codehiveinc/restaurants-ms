package com.codehive.restaurantsservice.restaurants.application.ports.outputs;

import com.codehive.restaurantsservice.restaurants.domain.models.RestaurantModel;

import java.util.List;
import java.util.UUID;

public interface IRestaurantPersistencePort {

    RestaurantModel create(RestaurantModel restaurantModel);

    List<RestaurantModel> list();

    RestaurantModel get(UUID uuid);

    void delete(UUID uuid);

    RestaurantModel findRestaurantByMealId(UUID mealId);
}

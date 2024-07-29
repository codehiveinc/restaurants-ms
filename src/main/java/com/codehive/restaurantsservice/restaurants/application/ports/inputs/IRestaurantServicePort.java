package com.codehive.restaurantsservice.restaurants.application.ports.inputs;

import com.codehive.restaurantsservice.restaurants.domain.models.RestaurantModel;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.dtos.requests.CreateMealRequest;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.dtos.requests.CreateRestaurantRequest;

import java.util.List;
import java.util.UUID;

public interface IRestaurantServicePort {

    RestaurantModel create(CreateRestaurantRequest request);

    List<RestaurantModel> list();

    RestaurantModel get(UUID uuid);

    void delete(UUID uuid);

    List<RestaurantModel> getRestaurantsByUserUUID(UUID userUUID);
}

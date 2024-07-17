package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.mappers;

import com.codehive.restaurantsservice.restaurants.domain.models.RestaurantModel;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.dtos.requests.CreateRestaurantRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IRestaurantModelMapper {

    RestaurantModel toRestaurantModel(CreateRestaurantRequest request);
}

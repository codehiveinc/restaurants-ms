package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.mappers;

import com.codehive.restaurantsservice.restaurants.domain.models.RestaurantModel;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.entities.RestaurantEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface IRestaurantEntityMapper {

    RestaurantEntity toRestaurantEntity(RestaurantModel restaurantModel);
    RestaurantModel toRestaurantModel(RestaurantEntity restaurantEntity);
}

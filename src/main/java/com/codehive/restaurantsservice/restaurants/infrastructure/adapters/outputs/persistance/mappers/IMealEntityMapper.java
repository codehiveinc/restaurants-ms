package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.mappers;

import com.codehive.restaurantsservice.restaurants.domain.models.MealModel;
import com.codehive.restaurantsservice.restaurants.domain.models.RestaurantModel;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.entities.MealEntity;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.entities.RestaurantEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IMealEntityMapper {

    MealEntity toMealEntity(MealModel mealModel);
    MealModel toMealModel(MealEntity mealEntity);
}
//RestaurantEntity toRestaurantEntity(RestaurantModel restaurantModel);
//RestaurantModel toRestaurantModel(RestaurantEntity restaurantEntity);
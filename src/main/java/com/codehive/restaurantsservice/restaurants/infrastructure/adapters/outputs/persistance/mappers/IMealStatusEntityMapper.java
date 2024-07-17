package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.mappers;

import com.codehive.restaurantsservice.restaurants.domain.models.MealStatusModel;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.entities.MealStatusEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IMealStatusEntityMapper {

    MealStatusEntity toMealStatusEntity(MealStatusModel mealStatusModel);
    MealStatusModel toMealStatusModel(MealStatusEntity mealStatusEntity);


}

//RestaurantEntity toRestaurantEntity(RestaurantModel restaurantModel);
//RestaurantModel toRestaurantModel(RestaurantEntity restaurantEntity);
package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.mappers;

import com.codehive.restaurantsservice.restaurants.domain.models.MealStatusModel;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface IMealStatusModelMapper {

    MealStatusModel toMealStatusModel(MealStatusModel request);
}

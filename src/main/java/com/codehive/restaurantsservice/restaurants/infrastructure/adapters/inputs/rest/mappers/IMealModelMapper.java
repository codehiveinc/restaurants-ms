package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.mappers;

import com.codehive.restaurantsservice.restaurants.domain.models.MealModel;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.dtos.requests.CreateMealRequest;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.dtos.requests.UpdateMealRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IMealModelMapper {

    MealModel toMealModel(CreateMealRequest request);
    MealModel toUpdateMealModel(UpdateMealRequest request);
}

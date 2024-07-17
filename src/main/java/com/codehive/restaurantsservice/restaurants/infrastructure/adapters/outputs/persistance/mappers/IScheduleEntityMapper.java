package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.mappers;

import com.codehive.restaurantsservice.restaurants.domain.models.RestaurantModel;
import com.codehive.restaurantsservice.restaurants.domain.models.ScheduleModel;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.entities.RestaurantEntity;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.entities.ScheduleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IScheduleEntityMapper {

    ScheduleEntity toScheduleEntity(ScheduleModel scheduleModel);
    ScheduleModel toScheduleModel(ScheduleEntity scheduleEntity);
}


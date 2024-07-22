package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.mappers;

import com.codehive.restaurantsservice.restaurants.domain.models.ScheduleModel;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.dtos.requests.CreateScheduleRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IScheduleModelMapper {

    ScheduleModel toScheduleModel(CreateScheduleRequest request);
}

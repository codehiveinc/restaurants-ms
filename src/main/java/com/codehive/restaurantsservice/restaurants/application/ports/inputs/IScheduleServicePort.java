package com.codehive.restaurantsservice.restaurants.application.ports.inputs;

import com.codehive.restaurantsservice.restaurants.domain.models.RestaurantModel;
import com.codehive.restaurantsservice.restaurants.domain.models.ScheduleModel;

import java.util.List;
import java.util.UUID;

public interface IScheduleServicePort {

    ScheduleModel create (ScheduleModel scheduleModel);

    ScheduleModel get (UUID uuid);

    List<ScheduleModel> list ();

    void delete (UUID uuid);


}

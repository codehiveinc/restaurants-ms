package com.codehive.restaurantsservice.restaurants.application.ports.outputs;

import com.codehive.restaurantsservice.restaurants.domain.models.ScheduleModel;

import java.util.List;
import java.util.UUID;

public interface ISchedulePersistencePort {

    ScheduleModel create (ScheduleModel scheduleModel);

    ScheduleModel get (UUID uuid);

    List<ScheduleModel> list ();

    void delete (UUID uuid);
}

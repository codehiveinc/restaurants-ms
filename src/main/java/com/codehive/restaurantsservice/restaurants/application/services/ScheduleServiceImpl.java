package com.codehive.restaurantsservice.restaurants.application.services;

import com.codehive.restaurantsservice.restaurants.application.ports.inputs.IScheduleServicePort;
import com.codehive.restaurantsservice.restaurants.application.ports.outputs.ISchedulePersistencePort;
import com.codehive.restaurantsservice.restaurants.domain.models.ScheduleModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ScheduleServiceImpl implements IScheduleServicePort {

    private final ISchedulePersistencePort persistencePort;

    public ScheduleServiceImpl(ISchedulePersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }

    @Override
    public ScheduleModel create(ScheduleModel scheduleModel) {
        return persistencePort.create(scheduleModel);
    }

    @Override
    public ScheduleModel get(UUID uuid) {
        return persistencePort.get(uuid);
    }

    @Override
    public List<ScheduleModel> list() {
        return persistencePort.list();
    }

    @Override
    public void delete(UUID uuid) {
        persistencePort.delete(uuid);
    }
}

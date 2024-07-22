package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance;

import com.codehive.restaurantsservice.restaurants.application.ports.outputs.ISchedulePersistencePort;
import com.codehive.restaurantsservice.restaurants.domain.models.ScheduleModel;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.entities.ScheduleEntity;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.mappers.IScheduleEntityMapper;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.repositories.ISchedulesRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class SchedulePersistenceAdapter implements ISchedulePersistencePort {

    private final ISchedulesRepository repository;
    private final IScheduleEntityMapper entityMapper;

    public SchedulePersistenceAdapter(ISchedulesRepository repository, IScheduleEntityMapper entityMapper) {
        this.repository = repository;
        this.entityMapper = entityMapper;
    }


    @Override
    public ScheduleModel create(ScheduleModel scheduleModel) {
        ScheduleEntity entity = entityMapper.toScheduleEntity(scheduleModel);
        ScheduleEntity createEntity = repository.save(entity);

        return entityMapper.toScheduleModel(createEntity);
    }

    @Override
    public ScheduleModel get(UUID uuid) {
        return repository.findByUUID(uuid)
                .map(entityMapper::toScheduleModel)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
    }

    @Override
    public List<ScheduleModel> list() {
        return repository.findAll()
                .stream()
                .map(entityMapper::toScheduleModel)
                .toList();
    }

    @Override
    public void delete(UUID uuid) {

        if (!repository.existsByUUID(uuid)) {
            throw new RuntimeException("Schedule not found");
        }

        repository.deleteByUUID(uuid);

    }
}

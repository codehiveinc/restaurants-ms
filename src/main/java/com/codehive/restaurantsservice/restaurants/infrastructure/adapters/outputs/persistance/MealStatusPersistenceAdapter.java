package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance;

import com.codehive.restaurantsservice.restaurants.application.ports.outputs.IMealStatusPersistencePort;
import com.codehive.restaurantsservice.restaurants.domain.models.MealStatusModel;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.mappers.IMealStatusEntityMapper;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.repositories.IMealStatusRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MealStatusPersistenceAdapter implements IMealStatusPersistencePort {

    private final IMealStatusRepository repository;

    private final IMealStatusEntityMapper mapper;

    public MealStatusPersistenceAdapter(IMealStatusRepository repository, IMealStatusEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public MealStatusModel get(UUID uuid) {
        return repository.findByUUID(uuid)
                .map(mapper::toMealStatusModel)
                .orElseThrow(() -> new RuntimeException("MealStatus not found"));
    }
}

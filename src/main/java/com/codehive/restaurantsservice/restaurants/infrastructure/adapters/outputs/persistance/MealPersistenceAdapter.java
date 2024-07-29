package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance;

import com.codehive.restaurantsservice.restaurants.application.ports.outputs.IMealPersistencePort;
import com.codehive.restaurantsservice.restaurants.domain.models.MealModel;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.entities.MealEntity;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.mappers.IMealEntityMapper;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.repositories.IMealRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MealPersistenceAdapter implements IMealPersistencePort {

    private final IMealRepository repository;
    private final IMealEntityMapper mapper;

    public MealPersistenceAdapter(IMealRepository repository, IMealEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public MealModel create(MealModel mealModel) {

        MealEntity entity = mapper.toMealEntity(mealModel);
        MealEntity createEntity = repository.save(entity);

        return mapper.toMealModel(createEntity);
    }

    @Override
    public MealModel get(UUID uuid){
        return repository.findByUUID(uuid)
                .map(mapper::toMealModel)
                .orElseThrow(() -> new RuntimeException("Meal not found"));
    }

    @Override
    public MealModel update(UUID uuid, MealModel mealModel) {
        return repository.findByUUID(uuid)
                .map(entity -> {
                    entity.setName(mealModel.getName());
                    entity.setDescription(mealModel.getDescription());
                    entity.setPrice(mealModel.getPrice());
                    entity.setImageUrl(mealModel.getImageUrl());
                    MealEntity updatedEntity = repository.save(entity);
                    return mapper.toMealModel(updatedEntity);
                })
                .orElseThrow(() -> new RuntimeException("Meal not found"));
    }

    @Override
    public List<MealModel> list(){
        return repository.findAll()
                .stream()
                .map(mapper::toMealModel)
                .toList();
    }

    @Override
    public void delete(UUID uuid) {
        if (!repository.existsByUUID(uuid)) {
            throw new RuntimeException("Meal not found");
        }
        repository.deleteByUUID(uuid);

    }
    @Override
    public MealModel getMealByKeyword(String name) {
        return repository.findByName(name)
                .map(mapper::toMealModel)
                .orElseThrow(() -> new RuntimeException("Meal not found"));
    }
}

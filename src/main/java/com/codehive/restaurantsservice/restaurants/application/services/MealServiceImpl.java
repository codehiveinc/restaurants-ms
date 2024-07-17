package com.codehive.restaurantsservice.restaurants.application.services;

import com.codehive.restaurantsservice.restaurants.application.ports.inputs.IMealServicePort;
import com.codehive.restaurantsservice.restaurants.application.ports.outputs.IMealPersistencePort;
import com.codehive.restaurantsservice.restaurants.domain.models.MealModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MealServiceImpl implements IMealServicePort {

    private final IMealPersistencePort persistencePort;

    public MealServiceImpl(IMealPersistencePort persistencePort){
        this.persistencePort = persistencePort;
    }


    @Override
    public MealModel create(MealModel mealModel) {
        return persistencePort.create(mealModel);
    }

    @Override
    public MealModel get(UUID uuid) {
        return persistencePort.get(uuid);
    }

    @Override
    public List<MealModel> list() {
        return persistencePort.list();
    }

    @Override
    public MealModel update(UUID uuid, MealModel mealModel) {
        return persistencePort.update(uuid, mealModel);
    }

    @Override
    public void delete(UUID uuid) {
        persistencePort.delete(uuid);

    }
}

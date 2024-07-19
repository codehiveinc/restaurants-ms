package com.codehive.restaurantsservice.restaurants.application.services;

import com.codehive.restaurantsservice.restaurants.application.ports.inputs.IMealServicePort;
import com.codehive.restaurantsservice.restaurants.application.ports.inputs.IMealStatusServicePort;
import com.codehive.restaurantsservice.restaurants.application.ports.outputs.IMealPersistencePort;
import com.codehive.restaurantsservice.restaurants.application.ports.outputs.IMealStatusPersistencePort;
import com.codehive.restaurantsservice.restaurants.domain.models.MealStatusModel;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class MealStatusServiceImpl implements IMealStatusServicePort {

    private final IMealStatusPersistencePort persistencePort;

    public MealStatusServiceImpl(IMealStatusPersistencePort persistencePort){
        this.persistencePort = persistencePort;
    }

    @Override
    public MealStatusModel get(UUID uuid) {
        return persistencePort.get(uuid);
    }
}

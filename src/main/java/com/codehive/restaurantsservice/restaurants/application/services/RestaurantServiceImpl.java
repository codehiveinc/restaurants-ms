package com.codehive.restaurantsservice.restaurants.application.services;

import com.codehive.restaurantsservice.restaurants.application.ports.inputs.IRestaurantServicePort;
import com.codehive.restaurantsservice.restaurants.application.ports.outputs.IRestaurantPersistencePort;
import com.codehive.restaurantsservice.restaurants.domain.models.RestaurantModel;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.dtos.requests.CreateMealRequest;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.dtos.requests.CreateRestaurantRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RestaurantServiceImpl implements IRestaurantServicePort {

    private final IRestaurantPersistencePort persistencePort;

    public RestaurantServiceImpl(IRestaurantPersistencePort persistencePort){
        this.persistencePort = persistencePort;
    }
    @Override
    public RestaurantModel create(CreateRestaurantRequest request) {
        RestaurantModel restaurantModel = new RestaurantModel();
        UUID uuid = UUID.randomUUID();
        restaurantModel.setUuid(uuid);
        restaurantModel.setName(request.getName());
        restaurantModel.setEmail(request.getEmail());
        restaurantModel.setLocation(request.getLocation());
        return persistencePort.create(restaurantModel);
    }

    @Override
    public List<RestaurantModel> list() {
        return persistencePort.list();
    }

    @Override
    public RestaurantModel get(UUID uuid) {
        return persistencePort.get(uuid);
    }

    @Override
    public void delete(UUID uuid) {

        persistencePort.delete(uuid);
    }

    public RestaurantModel getRestaurantByMealId(UUID mealId) {
        // Assuming the persistence port provides a method to find a restaurant by meal ID
        return persistencePort.findRestaurantByMealId(mealId);
    }


}

package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance;

import com.codehive.restaurantsservice.restaurants.application.ports.outputs.IRestaurantPersistencePort;
import com.codehive.restaurantsservice.restaurants.domain.models.RestaurantModel;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.entities.RestaurantEntity;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.mappers.IRestaurantEntityMapper;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.repositories.IRestaurantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class RestaurantPersistenceAdapter implements IRestaurantPersistencePort {

    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantEntityMapper modelMapper;

    public RestaurantPersistenceAdapter(IRestaurantRepository restaurantRepository, IRestaurantEntityMapper modelMapper) {
        this.restaurantRepository = restaurantRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RestaurantModel create(RestaurantModel restaurantModel) {
        RestaurantEntity entity = modelMapper.toRestaurantEntity(restaurantModel);
        RestaurantEntity createEntity = restaurantRepository.save(entity);

        return modelMapper.toRestaurantModel(createEntity);
    }

    @Override
    public List<RestaurantModel> list() {
        return restaurantRepository.findAll()
                .stream()
                .map(modelMapper::toRestaurantModel)
                .toList();
    }

    @Override
    public RestaurantModel get(UUID uuid) {
        return restaurantRepository.findByUUID(uuid)
                .map(modelMapper::toRestaurantModel)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant not found"));

    }

    @Override
    public void delete(UUID uuid) {

        if (!restaurantRepository.existsByUUID(uuid)) {
            throw new EntityNotFoundException("Restaurant not found");
        }

        restaurantRepository.deleteByUUID(uuid);

    }
}

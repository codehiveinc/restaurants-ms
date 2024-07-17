package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.repositories;

import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.entities.MealStatusEntity;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.entities.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IMealStatusRepository extends JpaRepository<MealStatusEntity, UUID>{

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM MealStatusEntity m WHERE m.uuid = ?1")
    boolean existsByUUID(UUID uuid);

    @Query(value = "SELECT * FROM meal_status WHERE uuid = ?1", nativeQuery = true)
    Optional<ScheduleEntity> findByUUID(UUID uuid);
}

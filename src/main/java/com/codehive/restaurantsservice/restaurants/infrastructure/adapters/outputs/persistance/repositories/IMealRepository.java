package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.repositories;

import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.entities.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IMealRepository extends JpaRepository<MealEntity, UUID>{


    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM MealEntity m WHERE m.uuid = ?1")
    boolean existsByUUID(UUID uuid);


    @Query(value = "SELECT * FROM meals WHERE uuid = ?1", nativeQuery = true)
    Optional<MealEntity> findByUUID(UUID uuid);

    @Modifying
    @Transactional
    @Query("DELETE FROM MealEntity m WHERE m.uuid = ?1")
    void deleteByUUID(UUID uuid);

}

package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "meal_status")
@Getter
@Setter
public class MealStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID uuid;

    private String name;

    @OneToMany(mappedBy = "mealStatus", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<MealEntity> meals;
}

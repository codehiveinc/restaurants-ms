package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "meals")
@Getter
@Setter
public class MealEntity {


    private UUID uuid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private float price;

    private String status;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonBackReference
    private RestaurantEntity restaurant;

    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private MealStatusEntity mealStatus;



}

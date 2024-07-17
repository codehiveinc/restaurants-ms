package com.codehive.restaurantsservice.restaurants.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class MealModel {

    private UUID uuid;

    private Long id;

    private String name;

    private String description;

    private float price;

    private String status;

    private String imageUrl;
}

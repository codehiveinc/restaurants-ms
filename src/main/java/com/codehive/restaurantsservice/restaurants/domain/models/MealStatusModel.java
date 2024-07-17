package com.codehive.restaurantsservice.restaurants.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class MealStatusModel {

    private UUID uuid;

    private Long id;

    private String name;
}

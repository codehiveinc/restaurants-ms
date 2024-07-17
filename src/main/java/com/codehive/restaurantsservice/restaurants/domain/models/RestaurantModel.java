package com.codehive.restaurantsservice.restaurants.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RestaurantModel {

    private UUID uuid;

    private Long id;

    private String name;

    private String location;
}

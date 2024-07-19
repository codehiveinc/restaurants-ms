package com.codehive.restaurantsservice.restaurants.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RestaurantModel {

    private Long id;

    private UUID uuid;

    private String name;

    private String location;

    private String email;

}

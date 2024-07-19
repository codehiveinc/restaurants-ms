package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
public class CreateRestaurantRequest {

    @NotBlank(message = "Name is require")
    private String name;
    @NotBlank(message = "Email is require")
    private String email;
    @NotBlank(message = "Location is require")
    private String location;
}

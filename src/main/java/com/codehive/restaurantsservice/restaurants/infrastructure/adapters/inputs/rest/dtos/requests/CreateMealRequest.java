package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMealRequest {

    @NotBlank(message = "Name is require")
    private String name;

    @NotBlank(message = "Description is require")
    private String description;

    @NotBlank(message = "Price is require")
    private Float price;
    @NotBlank(message = "Status is require")
    private String status;
    @NotBlank
    private String imageUrl;
}

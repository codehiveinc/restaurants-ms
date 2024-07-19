package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMealRequest {
    @NotBlank(message = "Name is require")
    private String name;

    @NotBlank(message = "Description is require")
    private String description;

    @NotNull(message = "Price is require")
    private Float price;

    @NotBlank(message = "Image URL is require")
    private String imageUrl;
}

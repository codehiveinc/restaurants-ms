package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateScheduleRequest {

    private String user_uuid;

    @NotBlank
    private String openingTime;

    @NotBlank
    private String closingTime;
}

package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GetMealStatusRequest {

    private UUID uuid;

    private Long id;
}

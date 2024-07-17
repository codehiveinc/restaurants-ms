package com.codehive.restaurantsservice.restaurants.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ScheduleModel {
    private UUID uuid;

    private Long id;
    private String openingTime;

    private String closingTime;
}

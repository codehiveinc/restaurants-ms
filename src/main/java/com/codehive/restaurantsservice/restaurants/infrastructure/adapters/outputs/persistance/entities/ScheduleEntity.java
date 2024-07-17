package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Entity
@Table(name = "schedules")
@Getter @Setter
public class ScheduleEntity {

    private UUID uuid;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String openingTime;

    private String closingTime;

    @OneToOne(mappedBy = "schedule", cascade = CascadeType.ALL)
    @JsonManagedReference
    private RestaurantEntity restaurant;
}

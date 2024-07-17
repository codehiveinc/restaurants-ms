package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.outputs.persistance.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
public class RestaurantEntity {

    private UUID uuid;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String location;

    private String openingTime;

    private String closingTime;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<MealEntity> meals;

    @OneToOne
    @JoinColumn(name = "schedule_id")
    @JsonBackReference
    private ScheduleEntity schedule;





}

package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.controllers;

import com.codehive.restaurantsservice.restaurants.application.ports.inputs.IMealStatusServicePort;
import com.codehive.restaurantsservice.restaurants.domain.models.MealStatusModel;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.dtos.responses.BaseResponse;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.mappers.IMealStatusModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/meal-status")
public class MealStatusRestAdapter {

    private final IMealStatusServicePort servicePort;

    private final IMealStatusModelMapper modelMapper;

    public MealStatusRestAdapter(IMealStatusServicePort servicePort, IMealStatusModelMapper modelMapper) {
        this.servicePort = servicePort;
        this.modelMapper = modelMapper;
    }

    @GetMapping("{uuid}")
    public ResponseEntity<BaseResponse>get(@PathVariable UUID uuid){
        MealStatusModel mealStatus = servicePort.get(uuid);

        BaseResponse response = BaseResponse.builder()
                .data(modelMapper.toMealStatusModel(mealStatus))
                .message("MealStatus found")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .code(HttpStatus.OK.value())
                .build();
        return response.toResponseEntity();
    }
}

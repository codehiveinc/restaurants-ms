package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.controllers;

import com.codehive.restaurantsservice.restaurants.application.ports.inputs.IMealServicePort;
import com.codehive.restaurantsservice.restaurants.domain.models.MealModel;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.dtos.requests.CreateMealRequest;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.dtos.requests.UpdateMealRequest;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.dtos.responses.BaseResponse;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.mappers.IMealModelMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/meals")
public class MealRestAdapter {

    private final IMealServicePort servicePort;

    private final IMealModelMapper modelMapper;

    public MealRestAdapter(IMealServicePort servicePort, IMealModelMapper modelMapper) {
        this.servicePort = servicePort;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<BaseResponse> list(){
        List<MealModel> meals = servicePort.list();

        BaseResponse response = BaseResponse.builder()
                .data(meals)
                .message("List of meals")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .code(HttpStatus.OK.value())
                .build();
        return response.toResponseEntity();
    }

    @GetMapping("{uuid}")
    public ResponseEntity<BaseResponse> get(@PathVariable UUID uuid){
        MealModel meal = servicePort.get(uuid);

        BaseResponse response = BaseResponse.builder()
                .data(meal)
                .message("Meal found")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .code(HttpStatus.OK.value())
                .build();
        return response.toResponseEntity();
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@Valid @RequestBody CreateMealRequest request){

        MealModel meal = servicePort.create(modelMapper.toMealModel(request));

        BaseResponse response = BaseResponse.builder()
                .data(meal)
                .message("Meal created")
                .success(true)
                .httpStatus(HttpStatus.CREATED)
                .code(HttpStatus.CREATED.value())
                .build();

        return response.toResponseEntity();

    }

    @PutMapping("{uuid}")
    public ResponseEntity<BaseResponse> update(@PathVariable UUID uuid, @Valid @RequestBody UpdateMealRequest request){
        MealModel meal = servicePort.update(uuid, modelMapper.toUpdateMealModel(request));

        BaseResponse response = BaseResponse.builder()
                .data(meal)
                .message("Meal updated")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .code(HttpStatus.OK.value())
                .build();

        return response.toResponseEntity();
    }

    @DeleteMapping("{uuid}")
    public ResponseEntity<BaseResponse> delete(@PathVariable UUID uuid){
        servicePort.delete(uuid);

        BaseResponse response = BaseResponse.builder()
                .data(null)
                .message("Meal deleted")
                .success(true)
                .httpStatus(HttpStatus.NO_CONTENT)
                .code(HttpStatus.NO_CONTENT.value())
                .build();

        return response.toResponseEntity();
    }
}


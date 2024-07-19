package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.controllers;

import com.codehive.restaurantsservice.restaurants.application.ports.inputs.IRestaurantServicePort;
import com.codehive.restaurantsservice.restaurants.domain.models.RestaurantModel;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.dtos.requests.CreateRestaurantRequest;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.dtos.responses.BaseResponse;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.mappers.IRestaurantModelMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/restaurants")
public class RestaurantRestAdapter  {

    private final IRestaurantServicePort servicePort;

    private final IRestaurantModelMapper modelMapper;

    public RestaurantRestAdapter(IRestaurantServicePort servicePort, IRestaurantModelMapper modelMapper) {
        this.servicePort = servicePort;
        this.modelMapper = modelMapper;
    }


    @GetMapping
    public ResponseEntity<BaseResponse> list(){
        List<RestaurantModel> restaurants = servicePort.list();

        BaseResponse response = BaseResponse.builder()
                .data(restaurants)
                .message("List of restaurants")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .code(HttpStatus.OK.value())
                .build();
        return response.toResponseEntity();
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@Valid @RequestBody CreateRestaurantRequest request){

        RestaurantModel restaurant = servicePort.create(modelMapper.toRestaurantModel(request));

        BaseResponse response = BaseResponse.builder()
                .data(restaurant)
                .message("Restaurant created")
                .success(true)
                .httpStatus(HttpStatus.CREATED)
                .code(HttpStatus.CREATED.value())
                .build();

        return response.toResponseEntity();

    }
    @GetMapping("{uuid}")
    public ResponseEntity<BaseResponse> get(@PathVariable UUID uuid){
        RestaurantModel restaurant = servicePort.get(uuid);

        BaseResponse response = BaseResponse.builder()
                .data(restaurant)
                .message("Restaurant retrieved")
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
                .message("Restaurant deleted")
                .success(true)
                .httpStatus(HttpStatus.NO_CONTENT)
                .code(HttpStatus.NO_CONTENT.value())
                .build();

        return response.toResponseEntity();
    }

}

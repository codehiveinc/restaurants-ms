package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.controllers;

import com.codehive.restaurantsservice.restaurants.application.ports.inputs.IScheduleServicePort;
import com.codehive.restaurantsservice.restaurants.domain.models.ScheduleModel;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.dtos.requests.CreateScheduleRequest;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.dtos.responses.BaseResponse;
import com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.mappers.IScheduleModelMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/schedules")
public class ScheduleRestAdapter {

    private final IScheduleServicePort servicePort;
    private final IScheduleModelMapper modelMapper;

    public ScheduleRestAdapter(IScheduleServicePort servicePort, IScheduleModelMapper modelMapper) {
        this.servicePort = servicePort;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<BaseResponse> list(){
        List<ScheduleModel> schedules = servicePort.list();

        BaseResponse response = BaseResponse.builder()
                .data(schedules)
                .message("List of schedules")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
        return response.toResponseEntity();
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@Valid @RequestBody CreateScheduleRequest request){
        ScheduleModel schedule = servicePort.create(modelMapper.toScheduleModel(request));

        BaseResponse response = BaseResponse.builder()
                .data(schedule)
                .message("Schedule created")
                .success(true)
                .httpStatus(HttpStatus.CREATED)
                .build();

        return response.toResponseEntity();

    }

    @GetMapping("{uuid}")
    public ResponseEntity<BaseResponse> get(@PathVariable UUID uuid){
        ScheduleModel schedule = servicePort.get(uuid);
        BaseResponse response = BaseResponse.builder()
                .data(schedule)
                .message("Schedule retrieved")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
        return response.toResponseEntity();
    }

    @DeleteMapping("{uuid}")
    public ResponseEntity<BaseResponse> delete(@PathVariable UUID uuid){
        servicePort.delete(uuid);
        BaseResponse response = BaseResponse.builder()
                .message("Schedule deleted")
                .success(true)
                .httpStatus(HttpStatus.NO_CONTENT)
                .build();
        return response.toResponseEntity();
    }

}

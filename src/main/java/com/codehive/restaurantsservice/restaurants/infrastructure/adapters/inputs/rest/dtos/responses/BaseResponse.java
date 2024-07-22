package com.codehive.restaurantsservice.restaurants.infrastructure.adapters.inputs.rest.dtos.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@Builder
public class BaseResponse {

    private Object data;
    private String message;
    private Boolean success;
    private HttpStatus httpStatus;
    private Integer code;

    public ResponseEntity<BaseResponse> toResponseEntity() {
        return new ResponseEntity<>(this, httpStatus);
    }
}

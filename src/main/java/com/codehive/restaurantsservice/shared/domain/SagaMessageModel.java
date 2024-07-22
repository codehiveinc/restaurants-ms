package com.codehive.restaurantsservice.shared.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SagaMessageModel {

    private String uuid;

    boolean success;

    Object data;

}

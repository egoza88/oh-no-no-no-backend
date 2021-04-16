package com.ohnonono.parking.response.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class PinResponse {

    private String pin;

    public PinResponse() {
        pin = "";
    }

    public PinResponse(String pin) {
        this.pin = pin;
    }
}

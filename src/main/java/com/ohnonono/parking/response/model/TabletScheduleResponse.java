package com.ohnonono.parking.response.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class TabletScheduleResponse {

    private String from;
    private String until;
    private String place;

    public TabletScheduleResponse() {
        this.from = "";
        this.until = "";
        this.place = "";
    }

    public TabletScheduleResponse(String from, String until, String place) {
        this.from = from;
        this.until = until;
        this.place = place;
    }
}

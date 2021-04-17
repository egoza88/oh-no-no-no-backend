package com.ohnonono.parking.service;

import org.springframework.http.ResponseEntity;

public interface ScheduleService {
    ResponseEntity<String> getSchedule(String token);

    ResponseEntity<String> createReservation(String token);

    ResponseEntity<String> deleteReservation(String token, String reservationId);
}

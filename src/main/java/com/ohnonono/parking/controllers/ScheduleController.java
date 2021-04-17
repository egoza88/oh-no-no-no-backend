package com.ohnonono.parking.controllers;

import com.ohnonono.parking.model.Credentials;
import com.ohnonono.parking.response.model.TabletScheduleResponse;
import com.ohnonono.parking.service.ScheduleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/schedule")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/getByPin")
    @ApiOperation(value = "Access user's schedule by pin", notes = "Return pin if it exists, empty string otherwise", response = String.class)
    ResponseEntity<TabletScheduleResponse> getPlace(@RequestHeader("PIN") String pin) {
        if(pin.equals("1743")) {
            return new ResponseEntity<>(new TabletScheduleResponse("2021-04-17T09:45:00","2021-04-17T16:15:00","101"), HttpStatus.OK);
        }else if(pin.equals("1234")){
            return new ResponseEntity<>(new TabletScheduleResponse("2021-04-17T08:15:00","2021-04-17T014:30:00","102"), HttpStatus.OK);
        }else if(pin.equals("7583")){
            return new ResponseEntity<>(new TabletScheduleResponse("2021-04-17T11:00:00","2021-04-17T18:15:00","105"), HttpStatus.OK);
        }

        return new ResponseEntity<>(new TabletScheduleResponse(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getSchedule")
    @ApiOperation(value = "Return all reservations", notes = "Return reservations for all users", response = String.class)
    ResponseEntity<String> getSchedule(@RequestHeader("X-authSessionId") String token) {
        return scheduleService.getSchedule(token);
    }

    @GetMapping("/getScheduleById")
    @ApiOperation(value = "Return user's reservations by user id", notes = "Return user's reservations by user id", response = String.class)
    ResponseEntity<String> getScheduleById(@RequestHeader("X-authSessionId") String token, @RequestBody Credentials reservationId) {
        return scheduleService.getSchedule(token);
    }

    @PostMapping("/createReservation")
    @ApiOperation(value = "Create reservation for a user", notes = "Create reservation for a user", response = String.class)
    ResponseEntity<String> createReservation(@RequestHeader("X-authSessionId") String token, @RequestBody Credentials reservationId) {
        return scheduleService.getSchedule(token);
    }

    @DeleteMapping("/deleteReservation")
    @ApiOperation(value = "Delete reservation for a user", notes = "Delete reservation for a user", response = String.class)
    ResponseEntity<String> deleteReservation(@RequestHeader("X-authSessionId") String token, @RequestBody Credentials reservationId) {
        return scheduleService.getSchedule(token);
    }
}

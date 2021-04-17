package com.ohnonono.parking.controllers;

import com.ohnonono.parking.response.model.TabletScheduleResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/schedule")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ScheduleController {

    @GetMapping("/getByPin")
    @ApiOperation(value = "Access user's schedule by pin", notes = "Return pin if it exists, empty string otherwise", response = String.class)
    ResponseEntity<TabletScheduleResponse> getPin(@RequestHeader("PIN") String pin) {
        if(pin.equals("4321")) {
            return new ResponseEntity<>(new TabletScheduleResponse("123","150","1A"), HttpStatus.OK);
        }

        return new ResponseEntity<>(new TabletScheduleResponse(), HttpStatus.BAD_REQUEST);
    }
}

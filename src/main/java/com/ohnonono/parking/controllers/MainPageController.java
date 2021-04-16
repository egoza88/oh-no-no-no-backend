package com.ohnonono.parking.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MainPageController {

    @GetMapping(value = "/")
    @ApiOperation(value = "Oh-no-no-no back-end server", notes = "Simple greetings", response = String.class)
    String getAllNotes() {
        return "Gerara here!";
    }
}

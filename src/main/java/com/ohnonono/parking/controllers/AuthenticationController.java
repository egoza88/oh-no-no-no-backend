package com.ohnonono.parking.controllers;

import com.ohnonono.parking.http.RequestManager;
import com.ohnonono.parking.model.Credentials;
import com.ohnonono.parking.response.model.EmptyJsonResponse;
import com.ohnonono.parking.response.model.PinResponse;
import com.ohnonono.parking.response.model.TokenResponse;
import com.ohnonono.parking.service.AuthenticationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    @ApiOperation(value = "Authenticate a user", notes = "Create or update note", response = String.class)
    ResponseEntity<TokenResponse> login(@RequestBody Credentials credentials) {
        return authenticationService.getAuthToken(credentials);
    }

    @PostMapping("/logout")
    @ApiOperation(value = "Close all existing sessions for the authenticated user", notes = "Close all existing sessions for the authenticated user. You obtain the authorization token needed to execute the request using POST", response = String.class)
    HttpStatus login(@RequestHeader("X-authSessionId") String token) {
        return HttpStatus.OK;
    }

    @GetMapping("/pin")
    @ApiOperation(value = "Get user's pin", notes = "Return pin if it exists, empty string otherwise", response = String.class)
    ResponseEntity<PinResponse> getPin(@RequestHeader("X-authSessionId") String token) {
        PinResponse pinResponse = authenticationService.getPin(token);
        return new ResponseEntity<>(pinResponse, HttpStatus.OK);
    }

    @PostMapping("/generatePin")
    @ApiOperation(value = "Generate user's pin", notes = "Return pin if it created successfully, empty string otherwise", response = String.class)
    ResponseEntity<PinResponse> generatePin(@RequestHeader("X-authSessionId") String token) {
        PinResponse pinResponse = authenticationService.generatePin(token);
        return new ResponseEntity<>(pinResponse, HttpStatus.OK);
    }
}

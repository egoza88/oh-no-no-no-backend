package com.ohnonono.parking.service;

import com.ohnonono.parking.PinDB;
import com.ohnonono.parking.dto.AuthResponse;
import com.ohnonono.parking.http.RequestManagerAuth;
import com.ohnonono.parking.model.Credentials;
import com.ohnonono.parking.response.model.PinResponse;
import com.ohnonono.parking.response.model.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private RequestManagerAuth requestManagerAuth;

    private PinDB pinDB = new PinDB();

    @Override
    public ResponseEntity<TokenResponse> getAuthToken(Credentials credentials) {
        AuthResponse response = requestManagerAuth.getAuthToken(credentials.getEmail(), credentials.getPassword());
        String role = requestManagerAuth.getRole(response.getAuthSessionId());

        if(!response.isSuccess()) {
            return new ResponseEntity<>(
                    new TokenResponse("", "", ""),
                    HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity<>(
                new TokenResponse(response.getAuthSessionId(), role, ""),
                HttpStatus.OK
        );
    }

    @Override
    public PinResponse getPin(String username) {
        if(!pinDB.hasPin(username)) {
            return new PinResponse();
        }
        return new PinResponse(pinDB.getPin(username));
    }

    @Override
    public PinResponse generatePin(String username) {
        if(pinDB.hasPin(username)) {
            return new PinResponse(pinDB.getPin(username));
        }
        return new PinResponse(pinDB.generatePin(username));
    }
}

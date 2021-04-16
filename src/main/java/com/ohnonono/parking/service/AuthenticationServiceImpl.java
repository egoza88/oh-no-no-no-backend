package com.ohnonono.parking.service;

import com.ohnonono.parking.dto.AuthResponse;
import com.ohnonono.parking.http.RequestManager;
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
    private RequestManager requestManager;

    @Override
    public ResponseEntity<TokenResponse> getAuthToken(Credentials credentials) {
        AuthResponse response = requestManager.getAuthToken(credentials.getEmail(), credentials.getPassword());
        String role = requestManager.getRole(response.getAuthSessionId());

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
    public PinResponse getPin(String token) {
        return new PinResponse();
    }

    @Override
    public PinResponse generatePin(String token) {
        return new PinResponse("4321");
    }
}

package com.ohnonono.parking.service;

import com.ohnonono.parking.model.Credentials;
import com.ohnonono.parking.response.model.PinResponse;
import com.ohnonono.parking.response.model.TokenResponse;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    ResponseEntity<TokenResponse> getAuthToken(Credentials credentials);

    PinResponse getPin(String username);

    PinResponse generatePin(String username);
}

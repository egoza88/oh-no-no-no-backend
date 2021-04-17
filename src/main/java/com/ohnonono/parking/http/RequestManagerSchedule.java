package com.ohnonono.parking.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohnonono.parking.dto.AuthResponse;
import okhttp3.Headers;
import okhttp3.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestManagerSchedule {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestManagerAuth.class);
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private final ObjectMapper objectMapper;

    public RequestManagerSchedule() {
        this.objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public AuthResponse getAuthToken(String login, String password) {
//        HttpResponseWrapper responseWrapper = HttpClient.sendPost(getAuthRequestUrl(),
//                Headers.of("Content-Type", "application/json", "Accept", "application/json"),
//                getAuthBody(login, password));
//
//        LOGGER.warn("@@@@@: " + responseWrapper.getBody());
//        if(!responseWrapper.isSuccessful()) {
//            return new AuthResponse();
//        }
//
//        try {
//            return objectMapper.readValue(responseWrapper.getBody(), AuthResponse.class);
//        } catch (JsonProcessingException e) {
//            LOGGER.error("Jackson failed to map measures response body to object", e);
//        }

        return new AuthResponse();
    }
}

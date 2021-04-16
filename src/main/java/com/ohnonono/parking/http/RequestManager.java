package com.ohnonono.parking.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohnonono.parking.dto.AuthResponse;
import com.ohnonono.parking.dto.role.RoleDTO;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RequestManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestManager.class);
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private final ObjectMapper objectMapper;

    public RequestManager() {
        this.objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public AuthResponse getAuthToken(String login, String password) {
        HttpResponseWrapper responseWrapper = HttpClient.sendPost(getAuthRequestUrl(),
                Headers.of("Content-Type", "application/json", "Accept", "application/json"),
                getAuthBody(login, password));

        LOGGER.warn("@@@@@: " + responseWrapper.getBody());
        if(!responseWrapper.isSuccessful()) {
            return new AuthResponse();
        }

        try {
            return objectMapper.readValue(responseWrapper.getBody(), AuthResponse.class);
        } catch (JsonProcessingException e) {
            LOGGER.error("Jackson failed to map measures response body to object", e);
        }

        return new AuthResponse();
    }

    public String getRole(String token) {
        HttpResponseWrapper responseWrapper = HttpClient.sendGet(getRoleRequestUrl(),
                Headers.of("Content-Type", "application/json",
                        "Accept", "application/json",
                        "X-authSessionId", token));

        LOGGER.warn("@@@@@: " + responseWrapper.getBody());
        if(!responseWrapper.isSuccessful()) {
            return "";
        }

        try {
            RoleDTO roleDTO = objectMapper.readValue(responseWrapper.getBody(), RoleDTO.class);
            return roleDTO.getWinstrom().getUzivatel().get(0).getRole();
        } catch (JsonProcessingException e) {
            LOGGER.error("Jackson failed to map measures response body to object", e);
        }

        return "";
    }

    public HttpUrl getAuthRequestUrl() {
        return new HttpUrl.Builder()
                .scheme("https")
                .host("rezervace.flexibee.eu")
                .addPathSegment("login-logout")
                .addPathSegment("login.json")
                .build();
    }

    public RequestBody getAuthBody(String login, String password) {
        return RequestBody.create("{\n" +
                "    \"username\":\""+login+"\",\n" +
                "    \"password\":\""+password+"\"\n" +
                "}", JSON);
    }

    public String getRoleRequestUrl() {
        return "https://rezervace.flexibee.eu/v2/c/rezervace1/uzivatel/(id=me()).json?detail=custom:kod,jmeno,prijmeni,role";
    }
}

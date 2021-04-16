package com.ohnonono.parking.response.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenResponse {

    private String authSessionId;
    private String role;
    private String errors;

    public TokenResponse() {
        this.authSessionId = "";
        this.role = "";
        this.errors = "";
    }

    public TokenResponse(String authSessionId, String role, String errors) {
        this.authSessionId = authSessionId;
        this.role = role;
        this.errors = errors;
    }
}

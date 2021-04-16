package com.ohnonono.parking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponse{

	@JsonProperty("authSessionId")
	private String authSessionId;

	@JsonProperty("csrfToken")
	private String csrfToken;

	@JsonProperty("success")
	private boolean success;

	@JsonProperty("refreshToken")
	private String refreshToken;

	public AuthResponse() {
		this.authSessionId = "";
		this.csrfToken = "";
		this.success = false;
		this.refreshToken = "";
	}

	public String getAuthSessionId(){
		return authSessionId;
	}

	public String getCsrfToken(){
		return csrfToken;
	}

	public boolean isSuccess(){
		return success;
	}

	public String getRefreshToken(){
		return refreshToken;
	}
}
package com.ohnonono.parking.dto.role;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleDTO{

	@JsonProperty("winstrom")
	private Winstrom winstrom;

	public Winstrom getWinstrom(){
		return winstrom;
	}
}
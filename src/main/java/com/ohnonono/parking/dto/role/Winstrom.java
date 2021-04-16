package com.ohnonono.parking.dto.role;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Winstrom{

	@JsonProperty("uzivatel")
	private List<UzivatelItem> uzivatel;

	@JsonProperty("@version")
	private String version;

	public List<UzivatelItem> getUzivatel(){
		return uzivatel;
	}

	public String getVersion(){
		return version;
	}
}
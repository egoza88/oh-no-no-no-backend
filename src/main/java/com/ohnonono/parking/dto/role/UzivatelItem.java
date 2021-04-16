package com.ohnonono.parking.dto.role;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UzivatelItem{

	@JsonProperty("kod")
	private String kod;

	@JsonProperty("role")
	private String role;

	@JsonProperty("role@showAs")
	private String roleShowAs;

	@JsonProperty("prijmeni")
	private String prijmeni;

	@JsonProperty("role@ref")
	private String roleRef;

	@JsonProperty("id")
	private int id;

	@JsonProperty("jmeno")
	private String jmeno;

	@JsonProperty("role@evidencePath")
	private String roleEvidencePath;

	public String getKod(){
		return kod;
	}

	public String getRole(){
		return role;
	}

	public String getRoleShowAs(){
		return roleShowAs;
	}

	public String getPrijmeni(){
		return prijmeni;
	}

	public String getRoleRef(){
		return roleRef;
	}

	public int getId(){
		return id;
	}

	public String getJmeno(){
		return jmeno;
	}

	public String getRoleEvidencePath(){
		return roleEvidencePath;
	}
}
package com.wesley.uol.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "woeid", "latt_long" })
public class CordenadaDTO {

	@JsonProperty("woeid")
	private Integer woeid;
	@JsonProperty("latt_long")
	private String lattLong;

	@JsonProperty("woeid")
	public Integer getWoeid() {
		return woeid;
	}

	@JsonProperty("woeid")
	public void setWoeid(Integer woeid) {
		this.woeid = woeid;
	}

	@JsonProperty("latt_long")
	public String getLattLong() {
		return lattLong;
	}

	@JsonProperty("latt_long")
	public void setLattLong(String lattLong) {
		this.lattLong = lattLong;
	}

}
package com.wesley.uol.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"min_temp", "max_temp"})
public class ConsolidatedWeatherDTO {

	@JsonProperty("min_temp")
	private String minTemp;
	@JsonProperty("max_temp")
	private String maxTemp;


	@JsonProperty("min_temp")
	public String getMinTemp() {
		return minTemp;
	}

	@JsonProperty("min_temp")
	public void setMinTemp(String minTemp) {
		this.minTemp = minTemp;
	}

	@JsonProperty("max_temp")
	public String getMaxTemp() {
		return maxTemp;
	}

	@JsonProperty("max_temp")
	public void setMaxTemp(String maxTemp) {
		this.maxTemp = maxTemp;
	}

}
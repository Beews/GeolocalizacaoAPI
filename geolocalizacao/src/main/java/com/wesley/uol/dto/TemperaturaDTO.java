package com.wesley.uol.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TemperaturaDTO {

	@JsonProperty("consolidated_weather")
	List<ConsolidatedWeatherDTO> consolidatedWeather = new ArrayList<>();

	@JsonProperty("consolidated_weather")
	public List<ConsolidatedWeatherDTO> getConsolidatedWeather() {
		return consolidatedWeather;
	}

	@JsonProperty("consolidated_weather")
	public void setConsolidatedWeather(List<ConsolidatedWeatherDTO> consolidatedWeather) {
		this.consolidatedWeather = consolidatedWeather;
	}

}

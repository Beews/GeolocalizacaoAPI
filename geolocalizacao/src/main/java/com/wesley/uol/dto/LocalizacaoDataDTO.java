package com.wesley.uol.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "city_name",
		"latitude", "longitude" })
public class LocalizacaoDataDTO {

	@JsonProperty("city_name")
	private String cityName;
	@JsonProperty("latitude")
	private String latitude;
	@JsonProperty("longitude")
	private String longitude;


	@JsonProperty("city_name")
	public String getCityName() {
		return cityName;
	}

	@JsonProperty("city_name")
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@JsonProperty("latitude")
	public String getLatitude() {
		return latitude;
	}

	@JsonProperty("latitude")
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@JsonProperty("longitude")
	public String getLongitude() {
		return longitude;
	}

	@JsonProperty("longitude")
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "LocalizacaoDataDTO [cityName=" + cityName + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

	
	
	

}
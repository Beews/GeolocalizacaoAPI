package com.wesley.uol.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "status", "data" })
public class GeolocalizacaoDTO {

	@JsonProperty("status")
	private String status;
	@JsonProperty("data")
	private LocalizacaoDataDTO data;

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("data")
	public LocalizacaoDataDTO getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(LocalizacaoDataDTO data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "GeolocalizacaoDTO [status=" + status + ", data=" + data + "]";
	}
	
}
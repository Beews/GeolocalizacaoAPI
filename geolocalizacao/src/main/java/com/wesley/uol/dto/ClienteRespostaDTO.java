package com.wesley.uol.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "cliente",
	"tempMax", "tempMin" })
public class ClienteRespostaDTO {

	@JsonProperty("cliente")
	private ClienteDTO clienteDTO;
	private String tempMax;
	private String tempMin;

	public ClienteRespostaDTO(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}

	@JsonProperty("cliente")
	public ClienteDTO getClienteDTO() {
		return clienteDTO;
	}

	@JsonProperty("cliente")
	public void setClienteDTO(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}

	public String getTempMax() {
		return tempMax;
	}

	public ClienteRespostaDTO setTempMax(String tempMax) {
		this.tempMax = tempMax;
		return this;
	}

	public String getTempMin() {
		return tempMin;
	}

	public ClienteRespostaDTO setTempMin(String tempMin) {
		this.tempMin = tempMin;
		return this;
	}

}

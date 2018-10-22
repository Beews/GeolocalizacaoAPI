package com.wesley.uol.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteDTO {

	private String nome;
	private Integer idade;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}


	@Override
	public String toString() {
		return "UsuarioDTO [nome=" + nome + ", idade=" + idade + "]";
	}

}

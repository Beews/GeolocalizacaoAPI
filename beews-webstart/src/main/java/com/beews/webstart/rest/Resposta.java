package com.beews.webstart.rest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.beews.webstart.util.StringUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Resposta {

	@JsonIgnore
	private static final Logger LOG = LogManager.getLogger(Resposta.class);

	private String mensagem;

	@JsonIgnore
	private String entidadeTipo;
	@JsonIgnore
	public static final String MENSSAGEM_SALVAR = "cadastrado com sucesso";
	@JsonIgnore
	public static final String MENSSAGEM_DELETAR = "excluido com sucesso";
	@JsonIgnore
	public static final String MENSSAGEM_ATUALIZAR = "atualizado com sucesso";

	public Resposta() {

	}

	public Resposta(Object object) {
		try {
			this.entidadeTipo = object.getClass().equals(String.class) ? (String) object : object.getClass().getSimpleName();
		} catch (NullPointerException e) {
			LOG.warn("Objeto para parametrizar esta nulo");
		}

	}
	

	private void retornoMensagem(String msg) {
		mensagem = entidadeTipo != null ? StringUtil.splitCamelCase(entidadeTipo) + " " + msg : msg;
	}

	public Resposta salvar() {
		this.retornoMensagem(MENSSAGEM_SALVAR);
		return this;
	}

	public Resposta deletar() {
		retornoMensagem(MENSSAGEM_DELETAR);
		return this;
	}

	public Resposta atualizar() {
		retornoMensagem(MENSSAGEM_ATUALIZAR);
		return this;
	}

	public Resposta comEstaMensagem(String mensagem) {
		retornoMensagem(mensagem);
		return this;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}

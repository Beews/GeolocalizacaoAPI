package com.wesley.uol.exeption.constant;

public enum ClienteMsgEnum {

	JA_CADASTRADO("cliente.ja.cadastrado"),
	NAO_EXISTE("cliente.nao.existe");

	private final String prop;

	private ClienteMsgEnum(String prop) {
		this.prop = prop;
	}

	@Override
	public String toString() {
		return prop;
	}

}

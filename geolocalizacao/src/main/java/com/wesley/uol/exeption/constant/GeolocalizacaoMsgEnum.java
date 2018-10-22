package com.wesley.uol.exeption.constant;

public enum GeolocalizacaoMsgEnum {

	LOCALIZACAO_NAO_ENCONTRADO("localizacao.nao.encontrada");

	private final String prop;

	private GeolocalizacaoMsgEnum(String prop) {
		this.prop = prop;
	}

	@Override
	public String toString() {
		return prop;
	}

}

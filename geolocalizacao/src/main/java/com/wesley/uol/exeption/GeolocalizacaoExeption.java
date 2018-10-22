package com.wesley.uol.exeption;

import com.wesley.uol.exeption.constant.GeolocalizacaoMsgEnum;

public class GeolocalizacaoExeption extends CustomException {

	private static final long serialVersionUID = -7275628133516271981L;

	private GeolocalizacaoExeption(GeolocalizacaoMsgEnum msg, Object... param) {
		super(msg.toString(), param);
	}
	
	public static GeolocalizacaoExeption localizacaoNaoEncontrada(String lat, String longg ) {
		return new GeolocalizacaoExeption(GeolocalizacaoMsgEnum.LOCALIZACAO_NAO_ENCONTRADO, lat,longg );
	}
	
	

}

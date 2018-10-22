package com.wesley.uol.exeption;

import com.wesley.uol.exeption.constant.ClienteMsgEnum;

public class ClienteExeption extends CustomException {

	private static final long serialVersionUID = -7275628133516271981L;

	private ClienteExeption(ClienteMsgEnum prop, Object... param) {
		super(prop.toString(), param);
	}
	
	public static ClienteExeption usuarioJaCadastrado(String cliente) {
		return new ClienteExeption(ClienteMsgEnum.JA_CADASTRADO, cliente);
	}
	
	public static ClienteExeption usuarioNaoExiste(String cliente) {
		return new ClienteExeption(ClienteMsgEnum.NAO_EXISTE, cliente);
	}
	

}

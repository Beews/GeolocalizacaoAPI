package com.wesley.uol.dto;

import java.util.ArrayList;
import java.util.List;

public class ListaCordenaDTO {

	List<CordenadaDTO> lista = new ArrayList<>();

	public List<CordenadaDTO> getLista() {
		return lista;
	}

	public void setLista(List<CordenadaDTO> lista) {
		this.lista = lista;
	}
	
}

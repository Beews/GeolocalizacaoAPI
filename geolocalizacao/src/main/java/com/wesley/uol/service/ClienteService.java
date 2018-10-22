package com.wesley.uol.service;

import java.util.List;

import com.wesley.uol.dto.ClienteDTO;
import com.wesley.uol.dto.ClienteRespostaDTO;
import com.wesley.uol.entity.ClienteEntity;
import com.wesley.uol.exeption.ClienteExeption;
import com.wesley.uol.exeption.GeolocalizacaoExeption;

public interface ClienteService {

	ClienteRespostaDTO cadastrar(ClienteDTO usuario) throws ClienteExeption, GeolocalizacaoExeption;

	List<ClienteEntity> todosClientes() throws ClienteExeption;

	ClienteEntity getClienteById(String id) throws ClienteExeption;

	void atulizar(ClienteDTO cliente, String nomeId) throws ClienteExeption;

	void deleteClienteById(String nomeId) throws ClienteExeption;

}

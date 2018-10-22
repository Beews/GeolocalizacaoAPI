package com.wesley.uol.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beews.webstart.anntotion.Delete;
import com.beews.webstart.anntotion.Get;
import com.beews.webstart.anntotion.Post;
import com.beews.webstart.anntotion.Put;
import com.beews.webstart.rest.Resposta;
import com.wesley.uol.dto.ClienteDTO;
import com.wesley.uol.dto.ClienteRespostaDTO;
import com.wesley.uol.entity.ClienteEntity;
import com.wesley.uol.exeption.ClienteExeption;
import com.wesley.uol.exeption.GeolocalizacaoExeption;
import com.wesley.uol.service.ClienteService;

@RestController
@RequestMapping(value="cliente")
public class ClienteRestController {

	@Autowired
	ClienteService clienteService;
	
	@Post("cadastrar")
	public ResponseEntity<ClienteRespostaDTO> cadastrarCliente(@RequestBody ClienteDTO cliente) throws ClienteExeption, GeolocalizacaoExeption   {
		return new ResponseEntity<>(clienteService.cadastrar(cliente), HttpStatus.ACCEPTED);
	}
	
	@Get("listar")
	public ResponseEntity<List<ClienteEntity>> listarClientes() throws ClienteExeption   {
		return new ResponseEntity<>(clienteService.todosClientes(), HttpStatus.ACCEPTED);
	}
	
	@Get("{nomeId}")
	public ResponseEntity<ClienteEntity> clientePorId(@PathVariable("nomeId") String id) throws ClienteExeption   {
		return new ResponseEntity<>(clienteService.getClienteById(id), HttpStatus.ACCEPTED);
	}
	
	@Put("{nomeId}")
	public ResponseEntity<Resposta> atualizarCliente(@RequestBody ClienteDTO cliente,@PathVariable("nomeId") String nomeId ) throws ClienteExeption   {
		clienteService.atulizar(cliente, nomeId);
		return new ResponseEntity<>(new Resposta(nomeId).atualizar(), HttpStatus.ACCEPTED);
	}
	
	@Delete("{nomeId}")
	public ResponseEntity<Resposta> deleteClientePorId(@PathVariable("nomeId") String nomeId) throws ClienteExeption   {
		clienteService.deleteClienteById(nomeId);
		return new ResponseEntity<>(new Resposta(nomeId).deletar(), HttpStatus.ACCEPTED);
	}
	
	
}

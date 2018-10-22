package com.wesley.uol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesley.uol.dto.ClienteDTO;
import com.wesley.uol.dto.ClienteRespostaDTO;
import com.wesley.uol.dto.ConsolidatedWeatherDTO;
import com.wesley.uol.dto.CordenadaDTO;
import com.wesley.uol.dto.GeolocalizacaoDTO;
import com.wesley.uol.entity.ClienteEntity;
import com.wesley.uol.exeption.ClienteExeption;
import com.wesley.uol.exeption.GeolocalizacaoExeption;
import com.wesley.uol.provider.GeolocalizacaoApiProvider;
import com.wesley.uol.provider.MeteorologiaApiProvider;
import com.wesley.uol.repository.ClienteRepository;
import com.wesley.uol.service.ClienteService;
import com.wesley.uol.util.MyIP;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	GeolocalizacaoApiProvider geolocalizacaoApiProvider;

	@Autowired
	MeteorologiaApiProvider meteorologiaApiProvider;

	@Autowired
	MyIP myIp;

	@Override
	public ClienteRespostaDTO cadastrar(ClienteDTO clienteDTO) throws ClienteExeption, GeolocalizacaoExeption {
		clienteRepository.save(parse(clienteDTO));
		ConsolidatedWeatherDTO consolidatedWeather = meteorologiaApiProvider
				.buscaConsolidatedWeatherByLocationId(getCordenada().getWoeid());
		return new ClienteRespostaDTO(clienteDTO).setTempMax(consolidatedWeather.getMaxTemp()).setTempMin(consolidatedWeather.getMinTemp());
	}


	@Override
	public List<ClienteEntity> todosClientes() throws ClienteExeption {
		return clienteRepository.findAll();
	}

	@Override
	public ClienteEntity getClienteById(String nomeId) throws ClienteExeption {
		ClienteEntity clienteEntity = clienteRepository.find(nomeId);
		if (clienteEntity == null)
			throw ClienteExeption.usuarioNaoExiste(nomeId);
		return clienteEntity;
	}

	@Override
	public void deleteClienteById(String nomeId) throws ClienteExeption {
		ClienteEntity clienteEntity = clienteRepository.find(nomeId);
		if (clienteEntity == null)
			throw ClienteExeption.usuarioNaoExiste(nomeId);
		clienteRepository.delete(clienteEntity);

	}

	@Override
	public void atulizar(ClienteDTO cliente, String nomeId) throws ClienteExeption {
		if(cliente.getNome()!=null && (clienteRepository.find(cliente.getNome()) ==null)) {
		ClienteEntity clienteEntity = clienteRepository.find(nomeId);
		if (clienteEntity == null)
			throw ClienteExeption.usuarioNaoExiste(nomeId);
		clienteRepository.delete(clienteEntity);
		clienteRepository.save(parse(cliente));
		}else
			throw ClienteExeption.usuarioJaCadastrado(cliente.getNome() + " não pode ser atualizado pois o mesmo");
		
		

	}

	private String getLattLong(GeolocalizacaoDTO geolocalizacao) {
		return geolocalizacao.getData().getLatitude() + "," + geolocalizacao.getData().getLongitude();
	}

	private String getLocation(GeolocalizacaoDTO geolocalizacao) {
		return geolocalizacao == null ? null : geolocalizacao.getData().getCityName();
	}

	private ClienteEntity parse(ClienteDTO dto) {
		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setNome(dto.getNome());
		clienteEntity.setIdade(dto.getIdade());
		return clienteEntity;
	}
	
	private CordenadaDTO getCordenada()
			throws GeolocalizacaoExeption {
		
		CordenadaDTO cordenada = null;
		GeolocalizacaoDTO geolocalizacao = geolocalizacaoApiProvider.buscarPorIp(myIp.findMyIP());
		if (!this.getLocation(geolocalizacao).equals(null))
			cordenada = meteorologiaApiProvider.buscaCordenadasByLocation(getLocation(geolocalizacao));
		
		if (cordenada == null)
			cordenada = meteorologiaApiProvider.buscaCordenadasByLattLong(getLattLong(geolocalizacao));

		if (cordenada == null)
			throw GeolocalizacaoExeption.localizacaoNaoEncontrada(geolocalizacao.getData().getLatitude(),
					geolocalizacao.getData().getLongitude());
		
		return cordenada;
	}


}

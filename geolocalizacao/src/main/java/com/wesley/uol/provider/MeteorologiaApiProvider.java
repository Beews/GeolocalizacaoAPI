package com.wesley.uol.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.wesley.uol.dto.ConsolidatedWeatherDTO;
import com.wesley.uol.dto.CordenadaDTO;
import com.wesley.uol.dto.TemperaturaDTO;

public class MeteorologiaApiProvider {

	@Autowired
	private RestTemplate restTemplate;

	private final static String URL = "https://www.metaweather.com/api/location/";

	public MeteorologiaApiProvider() {
	}

	public CordenadaDTO buscaCordenadasByLocation(String location) {
		CordenadaDTO[] lista = restTemplate.getForObject(URL + "search/?query=" + location, CordenadaDTO[].class);
		return lista.length > 0 ? lista[0] : null;
	}

	public CordenadaDTO buscaCordenadasByLattLong(String lattLong) {
		 CordenadaDTO[] lista = restTemplate.getForObject(URL + "search/?lattlong=" + lattLong, CordenadaDTO[].class);
		 return lista.length > 0 ? lista[0] : null;
	}

	public ConsolidatedWeatherDTO buscaConsolidatedWeatherByLocationId(Integer id) {
		return restTemplate.getForObject(URL + id + "/", TemperaturaDTO.class).getConsolidatedWeather().get(0);
	}

}

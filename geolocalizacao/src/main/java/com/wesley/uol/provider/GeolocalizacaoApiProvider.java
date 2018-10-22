package com.wesley.uol.provider;

import org.springframework.web.client.RestTemplate;

import com.wesley.uol.dto.GeolocalizacaoDTO;


public class GeolocalizacaoApiProvider {

	private final RestTemplate restTemplate;

	public GeolocalizacaoApiProvider() {
		restTemplate = new RestTemplate();
	}

	public GeolocalizacaoDTO buscarPorIp(String ip) {
		System.out.println(ip);
		return restTemplate.getForObject("https://ipvigilante.com/json/" + ip + "/default", GeolocalizacaoDTO.class);
	}
}

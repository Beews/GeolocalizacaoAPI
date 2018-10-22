package com.wesley.uol;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.wesley.uol.provider.GeolocalizacaoApiProvider;
import com.wesley.uol.provider.MeteorologiaApiProvider;
import com.wesley.uol.util.MyIP;

@Configuration
public class Configuracao {
	@Bean
	public RestTemplate restTemplateProduce() {
		return new RestTemplate();
	}
	
	@Bean
	public GeolocalizacaoApiProvider geolocalizacaoApiProviderProduce() {
		return new GeolocalizacaoApiProvider();
	}
	
	@Bean
	public MeteorologiaApiProvider meteorologiaApiProviderProduce() {
		return new MeteorologiaApiProvider();
	}
	
	@Bean
	public MyIP myIpProduces() {
		return new MyIP();
	}
	
	

}

package com.beews.webstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.beews.webstart.util.MsgProperties;


@Configuration
public class MenssagemBootConfig {

	 @Bean(initMethod = "init")
	 public MsgProperties msgPropertieBean() {
	 return new MsgProperties();
	 }
	


}

package com.wesley.uol;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.wesley.uol.util.MsgProperties;

@Configuration
@ComponentScan(basePackages = "com.wesley.uol")
@PropertySource(value = {"classpath:msg.properties"})
public class MenssagemConfig {

	 @Bean(initMethod = "init")
	 public MsgProperties msgPropertieBean() {
	 return new MsgProperties();
	 }
	


}

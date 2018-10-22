package com.wesley.uol.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class MyIP {

	public String findMyIP() {
		String ip = "Não definido";
		try {
			URL whatIsMyIP = new URL("http://checkip.amazonaws.com");
			BufferedReader reader = new BufferedReader(new InputStreamReader(whatIsMyIP.openStream()));
			ip = reader.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ip;
	}
}

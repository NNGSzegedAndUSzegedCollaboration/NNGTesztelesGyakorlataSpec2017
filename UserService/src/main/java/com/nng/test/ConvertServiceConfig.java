package com.nng.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:convert_service.properties")
public class ConvertServiceConfig {

	@Autowired
	private Environment environment;

	public String getConvertServiceConvertEndpoint() {
		return environment.getProperty("convert_service.endpoint.convert");
	}

}

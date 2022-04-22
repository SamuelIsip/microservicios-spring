package com.servicios.coche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CocheApplication {

	public static void main(String[] args) {
		SpringApplication.run(CocheApplication.class, args);
	}

}

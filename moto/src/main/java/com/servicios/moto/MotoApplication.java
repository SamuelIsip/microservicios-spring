package com.servicios.moto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MotoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MotoApplication.class, args);
	}

}

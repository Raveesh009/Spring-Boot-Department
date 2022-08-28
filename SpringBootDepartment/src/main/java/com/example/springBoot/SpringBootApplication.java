package com.example.springBoot;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;


@org.springframework.boot.autoconfigure.SpringBootApplication
@OpenAPIDefinition
public class SpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);
	}



}

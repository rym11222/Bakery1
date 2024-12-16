package com.example.demoBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.demoBot.service")
public class DemoBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBotApplication.class, args);
	}

}

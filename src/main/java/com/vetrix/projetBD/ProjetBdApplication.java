package com.vetrix.projetBD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({com.vetrix.projetBD.photo.PhotoStorageProperties.class})
public class ProjetBdApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetBdApplication.class, args);
	}

}

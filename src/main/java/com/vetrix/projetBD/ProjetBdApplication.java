package com.vetrix.projetBD;

import com.vetrix.projetBD.photo.PhotoStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({PhotoStorageProperties.class})
public class ProjetBdApplication {
		public static void main(String[] args) {
			SpringApplication.run(ProjetBdApplication.class, args);
		}
}
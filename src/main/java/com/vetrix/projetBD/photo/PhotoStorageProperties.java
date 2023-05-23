package com.vetrix.projetBD.photo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "data")
public class PhotoStorageProperties {
	private String productDir;
}
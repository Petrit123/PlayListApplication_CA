package com.PlaylistApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
public class PlaylistApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaylistApplication.class, args);
	}
	
	public void addCorsMappings(CorsRegistry registry) {
	  registry.addMapping("/api/**")
	   	  .allowedOrigins("http://localhost:8080", "http://localhost:5555")
		  .allowedMethods("POST", "GET",  "PUT", "OPTIONS", "DELETE")
		  .allowedHeaders("X-Auth-Token", "Content-Type")
		  .exposedHeaders("custom-header1", "custom-header2")
		  .allowCredentials(false)
		  .maxAge(4800);
	}

}

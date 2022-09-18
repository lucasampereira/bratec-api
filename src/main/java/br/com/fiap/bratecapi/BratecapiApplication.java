package br.com.fiap.bratecapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BratecapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BratecapiApplication.class, args);
	}

}

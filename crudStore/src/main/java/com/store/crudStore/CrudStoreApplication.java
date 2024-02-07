package com.store.crudStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class CrudStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudStoreApplication.class, args);
	}

}

package com.allobank.allobackendtest;

import javax.persistence.PersistenceUnit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.allobank.allobackendtest.repository"})
@EntityScan(basePackages = {"com.allobank.allobackendtest.model"})
public class AlloBackendTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlloBackendTestApplication.class, args);
	}

}

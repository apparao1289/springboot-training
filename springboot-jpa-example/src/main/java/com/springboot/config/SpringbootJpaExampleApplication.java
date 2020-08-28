package com.springboot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.springboot")
@EnableJpaRepositories(basePackages = "com.springboot.repository")
@EntityScan(basePackages = "com.springboot.entity")
public class SpringbootJpaExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaExampleApplication.class, args);
	}

}

package com.springboot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.test.controller")
public class SpringbootExample3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootExample3Application.class, args);
	}

}

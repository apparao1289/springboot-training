package com.test.springbootexample2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.test")
public class SpringbootExample2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootExample2Application.class, args);
	}

}

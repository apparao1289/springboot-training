package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	//@GetMapping("/hello")
	@RequestMapping(value = "/hello")
	public String hello() {
		return "Welcome to spring boot application";
	}

}

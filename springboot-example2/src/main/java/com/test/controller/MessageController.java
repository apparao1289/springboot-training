package com.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Student;

@RestController
public class MessageController {

	@RequestMapping(value = "/message")
	public Student getStudentDetails() {

		Student s = new Student();
		s.setName("Rao");
		s.setAge("26");
		s.setAddress("Banaglore");
		s.setStand("12");

		return s;
	}

}

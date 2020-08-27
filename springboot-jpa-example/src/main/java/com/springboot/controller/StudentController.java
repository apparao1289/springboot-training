package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Result;
import com.springboot.model.StudentDetails;
import com.springboot.service.StudentService;

@RestController
public class StudentController {
	
  @Autowired
  private StudentService studentService;

  @PostMapping(value = "/student/create")	
  public Result createStudent(@RequestBody StudentDetails studentDetails) {
	  
	  return studentService.createStudent(studentDetails);
  }
  
  @PutMapping(value = "/student/update/{id}/{stand}")
  public Result updateStudent(@PathVariable("id") Integer id, @PathVariable("stand") String stand) {
	  
	  return studentService.updateStudent(id, stand);
	  
  }
  
  @DeleteMapping(value = "/student/delete/{id}")
  public Result deleteStudentByID(@PathVariable("id") Integer id) {
	  
	  return studentService.deleteStudentById(id);
  }
  
  @GetMapping(value = "student/{id}")
  public StudentDetails getStudentDetilsById(@PathVariable("id") Integer id) {
	  
	  return studentService.getStudentDetailsById(id);
  }
  
  @GetMapping(value = "student")
  public List<StudentDetails> getStudentDetils() {
	  
	  return studentService.getStudentDetails();
  }
  
  @GetMapping(value = "student/age/{age}")
  public List<StudentDetails> getStudentDetailsByAge(@PathVariable Integer age) {
	  
	  return studentService.getStudentDetailsByAge(age);
  }
}

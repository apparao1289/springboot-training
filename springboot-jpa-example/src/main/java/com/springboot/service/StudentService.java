package com.springboot.service;

import java.util.List;

import com.springboot.model.Result;
import com.springboot.model.StudentDetails;

public interface StudentService {

	Result createStudent(StudentDetails studentDetails);
	
	Result updateStudent(Integer id, String stand);
	
	Result deleteStudentById(Integer id);

	StudentDetails getStudentDetailsById(Integer id);

	List<StudentDetails> getStudentDetails();

	Object getStudentDetailsByAge(Integer age);
	
	List<StudentDetails> getStudentDetails(Integer pageNumber,Integer pageSize,String sortValue);


}

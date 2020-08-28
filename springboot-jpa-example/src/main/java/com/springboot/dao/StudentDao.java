package com.springboot.dao;

import java.util.List;

import com.springboot.model.StudentDetails;

public interface StudentDao {

	boolean createStudent(StudentDetails studentDetails);
	
	void updateStudent(Integer id, String stand);
	
	void deleteStudentById(Integer id);

	StudentDetails getStudentDetailsById(Integer id);

	List<StudentDetails> getStudentDetails();

	List<StudentDetails> getStudentDetailsByAge(Integer age);
	
	List<StudentDetails> getStudentDetails(Integer pageNo, Integer pageSize,String sortValue);

}

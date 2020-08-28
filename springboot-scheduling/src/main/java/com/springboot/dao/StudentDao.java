package com.springboot.dao;

import java.util.List;

import com.springboot.entity.Student;

public interface StudentDao {
	
	List<Student> getStudentDetails();

	void updateStudentDetails(Integer id,Integer stand);

	void updateStudentDetailsAsync(Integer id, Integer stand);

}

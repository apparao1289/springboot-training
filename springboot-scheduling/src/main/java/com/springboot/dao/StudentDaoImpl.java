package com.springboot.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.entity.Student;
import com.springboot.repository.StudentRepository;
@Repository
public class StudentDaoImpl implements StudentDao {
	
	private static final Logger logger = Logger.getLogger(StudentDaoImpl.class);

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getStudentDetails() {

		List<Student> studentList = studentRepository.findAll();

		return studentList;
	}

	@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
	@Override
	public void updateStudentDetails(Integer id,Integer stand) {
		
		studentRepository.updateStudentUsingNamedParameters(id, stand.toString());
	}

	@Async
	@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
	@Override
	public void updateStudentDetailsAsync(Integer id, Integer stand) {
		
		logger.info("updateStudentDetailsAsync id:"+id +":: stand ::"+stand);
		studentRepository.updateStudentUsingNamedParameters(id, stand.toString());
		logger.info("updateStudentDetailsAsync process completed");
		
	}
}

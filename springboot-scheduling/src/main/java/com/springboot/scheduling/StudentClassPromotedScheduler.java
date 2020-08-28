package com.springboot.scheduling;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.springboot.dao.StudentDao;
import com.springboot.entity.Student;

@Component
public class StudentClassPromotedScheduler {

	@Autowired
	private StudentDao studentDao;
	
	//@Scheduled(fixedDelay = 50000)
	public void processStudents() {
		
		List<Student> studentList =studentDao.getStudentDetails();
		
		// Add one to stand column and update the student table.
		for(Student s : studentList) {
			Integer stand = Integer.parseInt(s.getStand().trim()) + 1;
			studentDao.updateStudentDetails(s.getId(),stand);
		}
	}
}

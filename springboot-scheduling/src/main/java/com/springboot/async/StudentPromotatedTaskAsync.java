package com.springboot.async;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.springboot.dao.StudentDao;
import com.springboot.entity.Student;

@Component
public class StudentPromotatedTaskAsync {
	
	private static final Logger logger = Logger.getLogger(StudentPromotatedTaskAsync.class);

	@Autowired
	private StudentDao studentDao;
	
	@Scheduled(fixedDelay = 50000)
	public void processStudents() {
		
		logger.info("scheduler started at:"+System.currentTimeMillis());
		
		List<Student> studentList =studentDao.getStudentDetails();
		
		// Add one to stand column and update the student table.
		for(Student s : studentList) {
			Integer stand = Integer.parseInt(s.getStand().trim()) + 1;
			studentDao.updateStudentDetailsAsync(s.getId(),stand);
		}
		
		logger.info("scheduler End at:"+System.currentTimeMillis());
	}
}

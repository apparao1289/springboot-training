package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.springboot.dao.StudentDao;
import com.springboot.model.Result;
import com.springboot.model.StudentDetails;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	@Override
	public Result createStudent(StudentDetails studentDetails) {

		boolean status = studentDao.createStudent(studentDetails);

		Result result = new Result();

		if (status) {
			result.setStatus("SUCCESS");
			result.setMessage("Student is created successfully");
		} else {
			result.setStatus("FAIL");
			result.setMessage("Some probleam in the system. Please try again");
		}

		return result;
	}

	@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
	@Override
	public Result updateStudent(Integer id, String stand) {

		studentDao.updateStudent(id, stand);

		Result result = new Result();
		result.setStatus("SUCCESS");
		result.setMessage("Student is updated successfully");
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Result deleteStudentById(Integer id) {
		
		studentDao.deleteStudentById(id);
		Result result = new Result();
		result.setStatus("SUCCESS");
		result.setMessage("Student is deleted");
		return result;
	}

	@Transactional(readOnly = true,propagation = Propagation.REQUIRED)
	@Override
	public StudentDetails getStudentDetailsById(Integer id) {
		
		return studentDao.getStudentDetailsById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<StudentDetails>	 getStudentDetails() {
		
		return studentDao.getStudentDetails();
	}

	@Transactional(readOnly = true)
	@Override
	public Object getStudentDetailsByAge(Integer age) {
		
		List<StudentDetails> list = studentDao.getStudentDetailsByAge(age);
		
		if(CollectionUtils.isEmpty(list)) {
			Result result = new Result();
			result.setMessage("No students found for given age.");
			result.setStatus("SUCCESS");
			return result;
		} else {
			return list;
		}
	}

	@Override
	public List<StudentDetails> getStudentDetails(Integer pageNumber, Integer pageSize,String sortValue) {
		
		if(null == pageNumber) {
			pageNumber = 1;
		}
		
		if(null == pageSize || pageSize == 0) {
			pageSize = 5;
		}
		
		pageNumber = pageNumber - 1;
		
		pageNumber = pageNumber < 0 ? 0 :pageNumber;
		
		List<StudentDetails> list = studentDao.getStudentDetails(pageNumber, pageSize,sortValue);
		
		return list;
	}

}

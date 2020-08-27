package com.springboot.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Student;
import com.springboot.model.StudentDetails;
import com.springboot.repository.StudentRepository;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public boolean createStudent(StudentDetails studentDetails) {

		Student student = new Student();
		student.setId(getStudentId());
		student.setName(studentDetails.getName());
		student.setAddress(studentDetails.getAddress());
		student.setAge(studentDetails.getAge());
		student.setStand(studentDetails.getStand());

		Student s = studentRepository.save(student);

		return s != null ? true : false;
	}

	private int getStudentId() {

		return studentRepository.findMaxStudentId();
	}

	@Override
	public void updateStudent(Integer id, String stand) {

		studentRepository.updateStudent(stand, id);

	}

	@Override
	public void deleteStudentById(Integer id) {

		studentRepository.deleteById(id);

		// studentRepository.deleteStudentById(id);
	}

	@Override
	public StudentDetails getStudentDetailsById(Integer id) {

		Optional<Student> student = studentRepository.findById(id);
		Student stuentEntity = student.get();

		StudentDetails studentDetails = new StudentDetails();
		BeanUtils.copyProperties(stuentEntity, studentDetails);

		/*
		 * studentDetails.setId(id); studentDetails.setName(stuentEntity.getName());
		 * studentDetails.setAddress(stuentEntity.getAddress());
		 * studentDetails.setStand(stuentEntity.getStand());
		 * studentDetails.setAge(stuentEntity.getAge());
		 */

		return studentDetails;
	}

	@Override
	public List<StudentDetails> getStudentDetails() {

		StudentDetails studentDetails = null;

		List<StudentDetails> list = new ArrayList<>();

		List<Student> studentList = studentRepository.findAll();

		for (Student s : studentList) {
			studentDetails = new StudentDetails();
			BeanUtils.copyProperties(s, studentDetails);
			list.add(studentDetails);
		}
		return list;
	}

	@Override
	public List<StudentDetails> getStudentDetailsByAge(Integer age) {
		StudentDetails studentDetails = null;
		List<StudentDetails> list = new ArrayList<>();
		
		List<Student> studentList = studentRepository.findByAge(age);
		
		for (Student s : studentList) {
			studentDetails = new StudentDetails();
			BeanUtils.copyProperties(s, studentDetails);
			list.add(studentDetails);
		}
		return list;
	}

}

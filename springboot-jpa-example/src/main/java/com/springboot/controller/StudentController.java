package com.springboot.controller;

import java.util.List;

import org.apache.log4j.Logger;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Student Details")
@RestController
public class StudentController {

	private static final Logger logger = Logger.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;

	@ApiOperation(value = "Create student", response = Result.class)
	@PostMapping(value = "/student/create")
	public Result createStudent(@RequestBody StudentDetails studentDetails) {

		logger.info("createStudent studentDetails :" + studentDetails.toString());
		return studentService.createStudent(studentDetails);
	}

	@ApiOperation(value = "Update student based on Id", response = Result.class)
	@PutMapping(value = "/student/update/{id}/{stand}")
	public Result updateStudent(@PathVariable("id") Integer id, @PathVariable("stand") String stand) {

		logger.info("updateStudent id:" + id + ":::sand::" + stand);
		return studentService.updateStudent(id, stand);

	}

	@ApiOperation(value = "Delete student based on Id", response = Result.class)
	@DeleteMapping(value = "/student/delete/{id}")
	public Result deleteStudentByID(@PathVariable("id") Integer id) {

		logger.debug("deleteStudentByID id:" + id);
		return studentService.deleteStudentById(id);
	}

	@ApiOperation(value = "Fetch the student details based on Id", response = StudentDetails.class)
	@GetMapping(value = "student/{id}")
	public Object getStudentDetilsById(@PathVariable("id") Integer id) {

		logger.debug("getStudentDetilsById id:" + id);
		try {
			return studentService.getStudentDetailsById(id);
		} catch (Exception e) {
			logger.error("Exception occuured in getStudentDetilsById::"+e);
			Result result = new Result();
			result.setStatus("ERROR");
			result.setMessage("NO student Id found.");
			return result;
		}

	}

	@ApiOperation(value = "Fetch All student details", response = List.class)
	@GetMapping(value = "student")
	public List<StudentDetails> getStudentDetils() {
		logger.error("Executing getStudentDetils...");
		return studentService.getStudentDetails();
	}

	@ApiOperation(value = "Fetch student details based on Age", response = List.class)
	@GetMapping(value = "student/age/{age}")
	public Object getStudentDetailsByAge(@PathVariable Integer age) {
		logger.info("getStudentDetailsByAge age:" + age);
		return studentService.getStudentDetailsByAge(age);
	}

	@ApiOperation(value = "Fetch the student detais based on page number and page size", response = List.class)
	@GetMapping(value = "student/pageNumber/{pageNumber}/pageSize/{pageSize}/sort/{sortValue}")
	public List<StudentDetails> getStudentDetils(@PathVariable("pageNumber") Integer pageNumber,
			@PathVariable("pageSize") Integer pageSize, @PathVariable("sortValue") String sortValue) {

		logger.debug(
				"getStudentDetils pageNumber::" + pageNumber + ":pageSize:" + pageSize + "::sortValue::" + sortValue);
		return studentService.getStudentDetails(pageNumber, pageSize, sortValue);
	}
}

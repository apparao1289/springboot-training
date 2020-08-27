package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	@Query(value = "select max(id) from com.springboot.entity.Student")
	int findMaxStudentId();

	@Modifying
	@Query(value = "UPDATE STUDENT SET STAND=:stand WHERE ID = :id", nativeQuery = true)
	void updateStudent(@Param("stand") String stand,@Param("id") Integer id);
	
	@Modifying
	@Query(value = "update com.springboot.entity.Student as s set s.stand = :stand  where s.id = :id")
	void updateStudentUsingNamedParameters(@Param("id") Integer id, @Param("stand") String stand);

	@Modifying
	@Query(value = "delete from com.springboot.entity.Student s where s.id = :id")
	void deleteStudentById(@Param("id") Integer id);

	List<Student> findByAge(Integer age);
	
	@Query(value = "select s from com.springboot.entity.Student s where s.age=:age")
	List<Student> findByAgeByNamedParameter(@Param("age") Integer age);
	
	Student findByNameAndAge(String name,Integer age);
	
	List<Student> findByAgeLessThan(Integer age);  // select * from student where age < :age
}

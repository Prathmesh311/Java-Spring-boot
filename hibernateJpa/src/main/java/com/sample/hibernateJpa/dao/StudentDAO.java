package com.sample.hibernateJpa.dao;

import java.util.List;

import com.sample.hibernateJpa.entity.Student;

public interface StudentDAO {
	
	void save(Student theStudent);
	
	Student getStudentById(int ID);
	
	List<Student> findAll();
	
	List<Student> findByFirstName(String firstName);
	
	Student update(Student theStudent);
	
	void delete(int ID);
	
	int deleteAll();

}

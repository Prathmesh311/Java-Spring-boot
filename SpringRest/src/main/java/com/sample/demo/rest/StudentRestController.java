package com.sample.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	@PostConstruct
	private void loadData() {
		theStudents = new ArrayList<Student>();
		
		theStudents.add(new Student("Prathmesh", "Bhondave"));
		theStudents.add(new Student("Swapnil", "Nikam"));
		theStudents.add(new Student("Kaustubh", "Adhav"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return theStudents;	
	}
	
	@GetMapping("/students/{studentID}")
	public Student getStudent(@PathVariable int studentID) {
		
		if(studentID >= theStudents.size() || studentID < 0) {
			throw new StudentNotFoundException("Student not fround with ID: " + studentID);
		}
		
		return theStudents.get(studentID);
	}
	
}

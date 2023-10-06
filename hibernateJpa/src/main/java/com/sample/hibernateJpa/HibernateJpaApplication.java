package com.sample.hibernateJpa;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sample.hibernateJpa.dao.StudentDAO;
import com.sample.hibernateJpa.entity.Student;

@SpringBootApplication
public class HibernateJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//readStudent(studentDAO);
			//QueryStudents(studentDAO);
			//QueryStudentsByFirstName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
			
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		// Delete All Students
		int numRowsDeleted = studentDAO.deleteAll();
		
		System.out.println("Deleted Students Count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		//Retrive student using primary key
		int StudentID = 3;
		
		//Delete the student from table
		studentDAO.delete(StudentID);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//Retrive student using primary key
		int StudentID = 3;
		Student myStudent = studentDAO.getStudentById(StudentID);
		
		//change firstName to Sangita
		myStudent.setFirstName("Sangita");
		
		//Update the student
		Student updatedStudent = studentDAO.update(myStudent);
		
		//Display updated student
		System.out.println("Updated Student: " + updatedStudent);
		
	}

	private void QueryStudentsByFirstName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByFirstName("Somesh");
		
		for(Student tempStudent: students) {
			System.out.println(tempStudent);
		}
		
	}

	private void QueryStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		
		for(Student tempStudent: students) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// Retrive the student by ID
		Student myStudent = studentDAO.getStudentById(1);
		
		System.out.println("Display student: " + myStudent);
		
	}

	private void createStudent(StudentDAO studentDAO) {
		
		//create student object
		System.out.println("Creating student.....");
		Student tempStudent = new Student("Somesh", "Bhondave", "prathmesh@gmail.com");
		
		//save student object
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent);
		
		//Display id of saved student
		System.out.println("New Student ID: " + tempStudent.getId());
		
	}

}

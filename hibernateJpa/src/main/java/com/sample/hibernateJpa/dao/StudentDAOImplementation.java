package com.sample.hibernateJpa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sample.hibernateJpa.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImplementation implements StudentDAO{
	
	//Create field for entity manager
	private EntityManager entityManager;
	
	
	//constructor to inject entity manager
	@Autowired
	public StudentDAOImplementation(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	//Implement save method
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}


	@Override
	public Student getStudentById(int ID) {
		return entityManager.find(Student.class, ID);
	}


	@Override
	public List<Student> findAll() {
		//Creating query
		TypedQuery<Student> theQuery = entityManager.createQuery("from Student order by firstName desc", Student.class);
		
		//Getting the result
		List<Student> students = theQuery.getResultList();
		return students;
	}


	@Override
	public List<Student> findByFirstName(String firstName) {
		//Creating query
		TypedQuery<Student> theQuery = entityManager.createQuery("from Student where firstName=:theData", Student.class);
		
		//Setting value for parameter
		theQuery.setParameter("theData", firstName);
		
		//getting result
		return theQuery.getResultList();
	}


	@Override
	@Transactional
	public Student update(Student theStudent) {
		return entityManager.merge(theStudent);
		
	}


	@Override
	@Transactional
	public void delete(int ID) {
		//Get the student using ID
		Student theStudent = entityManager.find(Student.class, ID);
		
		//Delete student from table
		entityManager.remove(theStudent);
	}


	@Override
	@Transactional
	public int deleteAll() {
		int numRowsDeleted = entityManager.createQuery("delete from Student").executeUpdate();
		
		return numRowsDeleted;
	}


}

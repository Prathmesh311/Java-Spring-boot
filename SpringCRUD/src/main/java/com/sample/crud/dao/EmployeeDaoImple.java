package com.sample.crud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.crud.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDaoImple implements EmployeeDao{
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoImple(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	

	@Override
	public List<Employee> findAll() {
		//Create query
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
		
		//Execute query and get result set
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}


	@Override
	public Employee findEmployee(int id) {
		
		Employee employee = entityManager.find(Employee.class, id);
		
		return employee;
	}


	@Override
	public Employee addEmployee(Employee theEmployee) {
		
		Employee dbEmployee = entityManager.merge(theEmployee);
		return dbEmployee;
	}


	@Override
	public void deleteEmployee(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		
		entityManager.remove(employee);
	}
	

}

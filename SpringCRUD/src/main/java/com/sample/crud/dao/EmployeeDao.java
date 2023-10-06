package com.sample.crud.dao;

import java.util.List;

import com.sample.crud.entity.Employee;

public interface EmployeeDao {
	
	List<Employee> findAll();
	
	Employee findEmployee(int id);
	
	Employee addEmployee(Employee theEmployee);
	
	void deleteEmployee(int id);

}

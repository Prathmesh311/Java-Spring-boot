package com.sample.crud.service;

import java.util.List;

import com.sample.crud.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	
	Employee findEmployee(int id);
	
	Employee addEmployee(Employee theEmployee);
	
	void deleteEmployee(int id);

}

package com.sample.crud.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.crud.dao.EmployeeRepository;
import com.sample.crud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository  = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findEmployee(int id) {
		Optional<Employee> result =  employeeRepository.findById(id);
		
		Employee employee = null;
		
		if(result.isPresent()) {
			employee = result.get();
		}
		else {
			throw new RuntimeException("No employee present with id: " + id);
		}
		
		return employee;
		
	}

	@Transactional
	@Override
	public Employee addEmployee(Employee theEmployee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(theEmployee);
	}

	@Transactional
	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}
	
	
	
	

}

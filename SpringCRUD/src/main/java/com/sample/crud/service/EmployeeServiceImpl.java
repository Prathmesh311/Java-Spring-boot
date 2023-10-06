package com.sample.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.crud.dao.EmployeeDao;
import com.sample.crud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDao theEmployeeDao) {
		employeeDao  = theEmployeeDao;
	}

	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public Employee findEmployee(int id) {
		return employeeDao.findEmployee(id);
	}

	@Transactional
	@Override
	public Employee addEmployee(Employee theEmployee) {
		// TODO Auto-generated method stub
		return employeeDao.addEmployee(theEmployee);
	}

	@Transactional
	@Override
	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
	}
	
	
	
	

}

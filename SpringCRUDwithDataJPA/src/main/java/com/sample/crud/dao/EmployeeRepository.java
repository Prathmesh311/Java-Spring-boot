package com.sample.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	//That's it nothing need to be added
}

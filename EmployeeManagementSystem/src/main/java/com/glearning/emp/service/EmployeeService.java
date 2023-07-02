package com.glearning.emp.service;

import java.util.List;

import com.glearning.emp.model.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	List<Employee> viewAllEmployee();

	Employee findEmployeeById(long id);

	void deleteEmployeeById(long id);
	
	Employee updateEmployeeById(long id, Employee employee);

}

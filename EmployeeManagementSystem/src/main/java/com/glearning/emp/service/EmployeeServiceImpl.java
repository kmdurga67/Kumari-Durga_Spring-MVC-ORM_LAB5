package com.glearning.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.emp.model.Employee;
import com.glearning.emp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

//	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
//		this.employeeRepository = employeeRepository;
//	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}

	@Override
	public List<Employee> viewAllEmployee() {
		List<Employee> employees = this.employeeRepository.findAll();
		return employees;
	}

	@Override
	public Employee findEmployeeById(long id) {
		Optional<Employee> optionalEmployee = this.employeeRepository.findById(id);

		if (optionalEmployee.isPresent()) {
			return optionalEmployee.get();
		}
		throw new IllegalArgumentException("Invalid Employee id passed"+id);
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);;

	}

	@Override
	public Employee updateEmployeeById(long id, Employee employee) {
		Optional<Employee> optionalEmployee = this.employeeRepository.findById(id);

		if (optionalEmployee.isPresent()) {
			 Employee employee1 = optionalEmployee.get();
			 employee1.setEmployeeFirstName(employee1.getEmployeeFirstName());
			 employee1.setEmployeeLastName(employee1.getEmployeeLastName());
			 employee1.setEmployeeEmail(employee1.getEmployeeEmail());
			 this.employeeRepository.save(employee1);
		}
		
		return employee;

	}

}

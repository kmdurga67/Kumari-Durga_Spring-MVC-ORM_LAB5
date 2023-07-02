package com.glearning.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glearning.emp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

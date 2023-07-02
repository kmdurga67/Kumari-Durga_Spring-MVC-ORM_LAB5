package com.glearning.emp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="Employee")
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@Column(name="employeeFirstName")
	private String employeeFirstName;
	
	@Column(name="employeeLastName")
	private String employeeLastName;
	
	@Column(name="employeeEmail")
	private String employeeEmail;
	

}

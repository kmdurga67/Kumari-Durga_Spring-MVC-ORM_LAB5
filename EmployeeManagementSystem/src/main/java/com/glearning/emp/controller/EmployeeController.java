package com.glearning.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.glearning.emp.model.Employee;
import com.glearning.emp.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model model) {
		List<Employee> employee = this.employeeService.viewAllEmployee();
		model.addAttribute("employees", employee);
		return "employees/list-employee";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		this.employeeService.saveEmployee(employee);
		return "redirect:/employees/list";
	}

	@GetMapping("/add")
	public String showFormForAdd(Model model) {
		// create model attribute to bind form data
		Employee employee = new Employee();

		model.addAttribute("employee", employee);

		return "employees/employee-form";
	}

	@PostMapping("/delete")
	public String deleteEmployee(@RequestParam("id") int id) {
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/employees/list";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {

		// get the book from the service
		Employee theEmployee = employeeService.findEmployeeById(id);

		// set book as a model attribute to pre-populate the form
		model.addAttribute("employee", theEmployee);

		return "employees/employee-update";
	}
}

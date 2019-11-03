package com.in28minutes.springboot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.springboot.model.Employees;
import com.in28minutes.springboot.model.Payroll;
import com.in28minutes.springboot.service.EmployeesService;
 
@RestController
public class employeesController {

	@Autowired
	private EmployeesService employeesService;
	
	@GetMapping("/employees")
	public List<Employees> retrieveAllEmployees() {
		return employeesService.getAllEmployees();
	}
    
	@GetMapping("/employees/payroll")
	public List<Payroll> getAllEmployees() {
		return employeesService.getAllPayroll();
	}

	
	
	@GetMapping("/employees/highestSalary")
	public double retrieveHighestSalary()
	{
		return employeesService.highestSalary();
	}
	
	
	@GetMapping("/employees/Salaryabv10000")
	public List<Employees> retrieveSalaryAbvTenThousand()
	{
		return employeesService.salaryAbvTenThousand();
	}
	
	@GetMapping("/employees/Setsal/{id}")
	public List<Employees> retrieveSetSalary(@PathVariable String id)
	{
		return employeesService.setSal(id);
	}
	
	
	@PostMapping("/employees/{empId}/payroll")
	public ResponseEntity<Void> registerEmployee(
			@PathVariable String empId) {

		Employees employee=employeesService.addEmployee(empId);

		if (employee == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(employee.getEmpId()).toUri();

		return ResponseEntity.created(location).build();
	}

}
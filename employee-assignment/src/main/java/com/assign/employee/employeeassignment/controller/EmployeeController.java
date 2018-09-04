package com.assign.employee.employeeassignment.controller;

import com.assign.employee.employeeassignment.exception.ResourceNotFoundException;
import com.assign.employee.employeeassignment.model.Employee;
import com.assign.employee.employeeassignment.repository.EmployeeRepository;
import com.assign.employee.employeeassignment.model.Company;
import com.assign.employee.employeeassignment.repository.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class EmployeeController {

	 @Autowired
	 EmployeeRepository employeeRepository;
	 
	 @Autowired
	 CompanyRepository companyRepository;	 
	 
	// Get All Employee
	 @GetMapping("/employee")
	 public List<Employee> getAllEmployee() {
	     return employeeRepository.findAll();
	 }
	 
	// Create a new Employee
	 @PostMapping("/employee")
	 public Employee createEmployee(@Valid @RequestBody Employee employee) {
	     return employeeRepository.save(employee);
	 }
	 
	// Get a Single Employee
	 @GetMapping("/employee/{id}")
	 public Employee getEmployeeById(@PathVariable(value = "id") Long employeeId) {
	     return employeeRepository.findById(employeeId)
	             .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
	 }
	 
	// Update a Employee
	 @PutMapping("/employee/{id}")
	 public Employee updateEmployee(@PathVariable(value = "id") Long employeeId,
	                                         @Valid @RequestBody Employee employeeDetails) {

		 Employee employee = employeeRepository.findById(employeeId)
	             .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));

	     
	     employee.setEmployee_name(employeeDetails.getEmployee_name());
	     employee.setEmployee_department(employeeDetails.getEmployee_department());
	     employee.setEmployee_company(employeeDetails.getEmployee_company());

	     Employee updatedEmployee = employeeRepository.save(employee);
	     return updatedEmployee;
	 }
	 
	// Delete a Employee
	 @DeleteMapping("/employee/{id}")
	 public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") Long employeeId) {
		 Employee employee = employeeRepository.findById(employeeId)
	             .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));

		 employeeRepository.delete(employee);

	     return ResponseEntity.ok().build();
	 }
	 
	 // Create a new Company
	 @PostMapping("/company")
	 public Company createDepartment(@Valid @RequestBody Company company) {
	     return companyRepository.save(company);
	 }	
 
}
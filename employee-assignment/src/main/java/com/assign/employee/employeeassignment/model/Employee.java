package com.assign.employee.employeeassignment.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "employees")
@EntityListeners(AuditingEntityListener.class)

public class Employee implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank
	@Size(min=4, message="Name should have atleast 4 characters")
	private String employee_name;
	
	@NotBlank
	@Size(min=4, message="Employee Department should have atleast 4 characters")
	private String employee_department;
	
	@NotBlank
	private String employee_company;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_department() {
		return employee_department;
	}

	public void setEmployee_department(String employee_department) {
		this.employee_department = employee_department;
	}

	public String getEmployee_company() {
		return employee_company;
	}

	public void setEmployee_company(String employee_company) {
		this.employee_company = employee_company;
	}


}


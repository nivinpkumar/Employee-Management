package com.assign.employee.employeeassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assign.employee.employeeassignment.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{

}

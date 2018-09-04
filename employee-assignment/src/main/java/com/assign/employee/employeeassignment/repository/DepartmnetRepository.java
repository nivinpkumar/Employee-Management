package com.assign.employee.employeeassignment.repository;

import com.assign.employee.employeeassignment.model.Employee;
import com.assign.employee.employeeassignment.model.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmnetRepository extends JpaRepository<Department, Long> {

	Page<Department> findByEmployeeId(Long postId, Pageable pageable);
}
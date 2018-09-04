package com.assign.employee.employeeassignment.controller;

import com.assign.employee.employeeassignment.exception.ResourceNotFoundException;
import com.assign.employee.employeeassignment.model.Employee;
import com.assign.employee.employeeassignment.model.Department;
import com.assign.employee.employeeassignment.repository.DepartmnetRepository;
import com.assign.employee.employeeassignment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	DepartmnetRepository departmentRepository;
	
	@GetMapping("/employee/{id}/departments")
    public Page<Department> getAllCommentsByPostId(@PathVariable (value = "id") Long postId,
                                                Pageable pageable) {
        return departmentRepository.findByEmployeeId(postId, pageable);
    }
	
	@PostMapping("/employee/{id}/departments")
    public Department createDepartment(@PathVariable (value = "id") Long postId,
                                 @Valid @RequestBody Department comment) {
        return employeeRepository.findById(postId).map(post -> {
            comment.setEmployee(post);
            return departmentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found", null, comment));
    }


}

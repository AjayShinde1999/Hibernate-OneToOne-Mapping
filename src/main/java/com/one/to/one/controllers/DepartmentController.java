package com.one.to.one.controllers;

import com.one.to.one.entities.Department;
import com.one.to.one.services.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
        return new ResponseEntity<>(departmentService.saveDepartment(department), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{departmentId}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable long departmentId){
        return ResponseEntity.ok(departmentService.getDepartmentById(departmentId));
    }

    @PutMapping(path = "/{departmentId}/manager/{employeeId}")
    public ResponseEntity<Department> assignManagerToDepartment(@PathVariable long departmentId,
                                                                @PathVariable long employeeId
                                                                ){
        return ResponseEntity.ok(departmentService.assignManagerToDepartment(departmentId,employeeId));
    }

    @GetMapping(path = "/assignedDepartment/{employeeId}")
    public ResponseEntity<Department> getAssignedDepartmentOfManager(@PathVariable long employeeId){
        return ResponseEntity.ok(departmentService.getAssignedDepartmentOfManager(employeeId));
    }
}

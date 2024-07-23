package com.one.to.one.controllers;

import com.one.to.one.entities.Employee;
import com.one.to.one.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long employeeId){
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }
}

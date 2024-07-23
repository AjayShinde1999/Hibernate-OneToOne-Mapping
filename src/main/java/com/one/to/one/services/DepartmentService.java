package com.one.to.one.services;

import com.one.to.one.entities.Department;
import com.one.to.one.entities.Employee;
import com.one.to.one.repositories.DepartmentRepository;
import com.one.to.one.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(long id) {
        return departmentRepository.findById(id).get();
    }

    public Department assignManagerToDepartment(long departmentId, long employeeId) {
        Department department = departmentRepository.findById(departmentId).get();
        Employee manager = employeeRepository.findById(employeeId).get();

        if (department.getManager() != null) {
            throw new IllegalArgumentException("Already manager is assigned to this department");
        }

        if (manager.getManagedDepartment() != null) {
            throw new IllegalArgumentException("Employee already manages another department.");
        }
        department.setManager(manager);
        return departmentRepository.save(department);
    }

    public Department getAssignedDepartmentOfManager(long employeeId) {
        // 1st way
//        return departmentRepository.findByManager(employeeId);

        // 2nd way
        Employee employee = employeeRepository.findById(employeeId).get();
        return employee.getManagedDepartment();
    }
}

package com.one.to.one.repositories;

import com.one.to.one.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findByManager(long employeeId);
}

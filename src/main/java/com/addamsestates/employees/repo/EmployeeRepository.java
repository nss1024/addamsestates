package com.addamsestates.employees.repo;

import com.addamsestates.employees.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

package com.addamsestates.employees.repo;

import com.addamsestates.employees.model.Employee;
import com.addamsestates.users.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findFirstByOrderByEmployeeIdDesc();

}

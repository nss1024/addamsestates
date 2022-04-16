package com.addamsestates.employees.repo;

import com.addamsestates.employees.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EnquiriesRepository extends JpaRepository<Employee, Long> {

}

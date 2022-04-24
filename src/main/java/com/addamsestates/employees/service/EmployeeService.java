package com.addamsestates.employees.service;

import com.addamsestates.employees.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmployeeById(Long id);

    void addNewEmployee (Employee e);

    List<Employee> getAllEmployees();



}

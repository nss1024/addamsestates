package com.addamsestates.employees.service;

import com.addamsestates.employees.model.Employee;

public interface EmployeeService {

    Employee egtEmployeeById(Long id);

    void addNewEmployee (Employee e);

}

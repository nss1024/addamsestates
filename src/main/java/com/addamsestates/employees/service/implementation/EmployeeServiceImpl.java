package com.addamsestates.employees.service.implementation;

import com.addamsestates.employees.model.Employee;
import com.addamsestates.employees.repo.EmployeeRepository;
import com.addamsestates.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee egtEmployeeById(Long id) {
        return employeeRepository.getById(id);
    }

    @Override
    public void addNewEmployee(Employee e) {
            employeeRepository.save(e);
    }
}

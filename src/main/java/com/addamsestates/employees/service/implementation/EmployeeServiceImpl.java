package com.addamsestates.employees.service.implementation;

import com.addamsestates.employees.model.Employee;
import com.addamsestates.employees.repo.EmployeeRepository;
import com.addamsestates.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.getById(id);
    }

    @Override
    public void addNewEmployee(Employee e) {
            employeeRepository.save(e);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getLastInserted() {
        return employeeRepository.findFirstByOrderByEmployeeIdDesc();
    }
}

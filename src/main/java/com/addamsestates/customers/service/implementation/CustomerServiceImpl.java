package com.addamsestates.customers.service.implementation;

import com.addamsestates.customers.model.Customers;
import com.addamsestates.customers.repo.CustomerRepository;
import com.addamsestates.customers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customers> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customers getCustomerbyId(Long id) {
        return customerRepository.getById(id);
    }

    @Override
    public List<Customers> getCustomersByFirstName(String fName) {
        return customerRepository.getByFirstName(fName);
    }

    @Override
    public List<Customers> getCustomersByLastName(String lName) {
        return customerRepository.getByLastName(lName);
    }

    @Override
    public void addNewCustomer(Customers c) {
        customerRepository.save(c);
    }
}

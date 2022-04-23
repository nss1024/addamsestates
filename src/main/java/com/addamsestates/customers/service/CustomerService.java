package com.addamsestates.customers.service;

import com.addamsestates.customers.model.Customers;

import java.util.List;

public interface CustomerService {

    List<Customers> getAllCustomers();

    Customers getCustomerbyId(Long id);

    List<Customers> getCustomersByFirstName(String fname);

    List<Customers> getCustomersByLastName(String lname);

    void addNewCustomer(Customers c);


}

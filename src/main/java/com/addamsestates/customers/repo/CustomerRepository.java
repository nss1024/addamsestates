package com.addamsestates.customers.repo;

import com.addamsestates.customers.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customers, Long> {

    List<Customers> getByFirstName(String fname);

    List<Customers> getByLastName(String lname);

}

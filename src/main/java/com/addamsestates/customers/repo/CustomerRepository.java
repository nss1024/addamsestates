package com.addamsestates.customers.repo;

import com.addamsestates.customers.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CustomerRepository extends JpaRepository<Customers, Long> {
}

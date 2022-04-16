package com.addamsestates.branch.repo;

import com.addamsestates.branch.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;



public interface SalesRepository extends JpaRepository<Sales, Long> {
}

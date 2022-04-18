package com.addamsestates.employees.repo;

import com.addamsestates.employees.model.Employee;
import com.addamsestates.employees.model.Enquiries;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EnquiriesRepository extends JpaRepository<Enquiries, Long> {

    List<Enquiries> getByEmployeeId(Long id);

    List<Enquiries> getByEmployeeIdAndCompleted(Long id, Boolean isCompleted);

}

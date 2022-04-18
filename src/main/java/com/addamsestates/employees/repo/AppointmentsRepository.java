package com.addamsestates.employees.repo;

import com.addamsestates.employees.model.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AppointmentsRepository extends JpaRepository<Appointments, Long> {

    List<Appointments> getByEmployeeId(Long id);

    List<Appointments> getByEmployeeIdAndCompleted(Long id, Boolean isCompleted);

}

package com.addamsestates.employees.repo;

import com.addamsestates.employees.model.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AppointmentsRepository extends JpaRepository<Appointments, Long> {
}

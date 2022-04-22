package com.addamsestates.employees.service;

import com.addamsestates.employees.model.Appointments;

import java.util.List;

public interface AppointmentsService {

    List<Appointments> getAllAppointmentsByEmployeeId(Long id);

    List<Appointments> getCompletedAppointmentsByEmployeeId(Long id);

    List<Appointments> outstandingAppointmentsByEmployeeId(Long id);

    void addNewAppointment(Appointments a);

    void updateAppointment(Appointments a);

    Appointments getAppointmentById(Long id);

}

package com.addamsestates.employees.service.implementation;

import com.addamsestates.employees.model.Appointments;
import com.addamsestates.employees.repo.AppointmentsRepository;
import com.addamsestates.employees.service.AppointmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentsServiceImpl implements AppointmentsService {

    @Autowired
    AppointmentsRepository appointmentsRepository;

    @Override
    public List<Appointments> getAllAppointmentsByEmployeeId(Long id) {
        return appointmentsRepository.getByEmployeeId(id);
    }

    @Override
    public List<Appointments> getCompletedAppointmentsByEmployeeId(Long id) {
        return appointmentsRepository.getByEmployeeIdAndCompleted(id,true);
    }

    @Override
    public List<Appointments> outstandingAppointmentsByEmployeeId(Long id) {
        return appointmentsRepository.getByEmployeeIdAndCompleted(id,false);
    }
}

package com.addamsestates.employees.service.implementation;

import com.addamsestates.employees.model.Enquiries;
import com.addamsestates.employees.repo.EnquiriesRepository;
import com.addamsestates.employees.service.EnquiriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnquiriesServiceImplementation implements EnquiriesService {

    @Autowired
    EnquiriesRepository enquiriesRepository;

    @Override
    public List<Enquiries> getAllEnquiriesByEmployeeId(Long id) {
        return enquiriesRepository.getByEmployeeId(id);
    }

    @Override
    public List<Enquiries> getCompletedEnquiriesByEmployeeId(Long id) {
        return enquiriesRepository.getByEmployeeIdAndCompleted(id,true);
    }

    @Override
    public List<Enquiries> getOutstandingEnquiriesByEmployeeId(Long id) {
        return enquiriesRepository.getByEmployeeIdAndCompleted(id,false);
    }

    @Override
    public void addNewEnquiry(Enquiries e) {
        enquiriesRepository.save(e);
    }
}

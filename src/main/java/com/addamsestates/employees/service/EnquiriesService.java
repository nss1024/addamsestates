package com.addamsestates.employees.service;

import com.addamsestates.employees.model.Enquiries;

import java.util.List;

public interface EnquiriesService {

    List<Enquiries> getAllEnquiriesByEmployeeId(Long id);

    List<Enquiries> getCompletedEnquiriesByEmployeeId(Long id);

    List<Enquiries> getOutstandingEnquiriesByEmployeeId(Long id);

    void addNewEnquiry(Enquiries e);

}

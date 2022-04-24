package com.addamsestates.branch.service;

import com.addamsestates.branch.model.InternalServices;

import java.util.List;

public interface InternalServicesService {

    List<InternalServices> getAllInternalServices();

    List<InternalServices> getAllActiveInternalServices();

    InternalServices getInternalServiceById(Long id);

    void updateInternalService (InternalServices is);

}

package com.addamsestates.branch.service.implementation;

import com.addamsestates.branch.model.InternalServices;
import com.addamsestates.branch.repo.InternalServicesRepository;
import com.addamsestates.branch.service.InternalServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternalServicesServiceImpl implements InternalServicesService {

    @Autowired
    InternalServicesRepository internalServicesRepository;


    @Override
    public List<InternalServices> getAllInternalServices() {
        return internalServicesRepository.findAll();
    }

    @Override
    public List<InternalServices> getAllActiveInternalServices() {
        return internalServicesRepository.getByActive(true);
    }

    @Override
    public InternalServices getInternalServiceById(Long id) {
        return internalServicesRepository.getById(id);
    }

    @Override
    public void updateInternalService(InternalServices is) {
        internalServicesRepository.save(is);
    }
}

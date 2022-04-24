package com.addamsestates.branch.service.implementation;

import com.addamsestates.branch.model.Services;
import com.addamsestates.branch.repo.ServicesRepository;
import com.addamsestates.branch.service.ServicesService;
import org.hibernate.cfg.annotations.reflection.internal.JPAXMLOverriddenAnnotationReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesServiceImpl implements ServicesService {

    @Autowired
    ServicesRepository servicesRepository;

    @Override
    public Services getById(Long id) {
        return servicesRepository.getById(id);
    }

    @Override
    public List<Services> getAll() { return servicesRepository.findAll(); }

    @Override
    public List<Services> getByActive(){
        return servicesRepository.getByActive(true);
    }

    @Override
    public void updateService(Services s) {
        servicesRepository.save(s);
    }
}

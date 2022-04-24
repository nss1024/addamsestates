package com.addamsestates.branch.service;

import com.addamsestates.branch.model.Services;

import java.util.List;

public interface ServicesService {

    Services getById(Long id);

    List<Services> getAll();

    List<Services> getByActive();

    void updateService(Services s);

}

package com.addamsestates.branch.service.implementation;

import com.addamsestates.branch.model.Contracts;
import com.addamsestates.branch.repo.ContractsRepository;
import com.addamsestates.branch.service.ContractsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractsServiceImpl implements ContractsService {

    @Autowired
    private ContractsRepository contractsRepository;


    @Override
    public List<Contracts> getAllContracts() {
        return contractsRepository.findAll();
    }

    @Override
    public List<Contracts> getByType(String type) {
        return contractsRepository.getByType(type);
    }
}

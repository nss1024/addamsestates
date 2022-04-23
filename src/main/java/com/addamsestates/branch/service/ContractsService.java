package com.addamsestates.branch.service;

import com.addamsestates.branch.model.Contracts;

import java.util.List;

public interface ContractsService {

    List<Contracts> getAllContracts();

    List<Contracts> getByType(String type);

}

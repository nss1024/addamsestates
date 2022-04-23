package com.addamsestates.branch.repo;

import com.addamsestates.branch.model.Contracts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ContractsRepository extends JpaRepository<Contracts, Long> {

    List<Contracts> getByType(String type);

}

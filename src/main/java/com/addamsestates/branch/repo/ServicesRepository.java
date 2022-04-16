package com.addamsestates.branch.repo;

import com.addamsestates.branch.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ServicesRepository extends JpaRepository<Services, Long> {

    List<Services> getByActive(Boolean isActive);

}

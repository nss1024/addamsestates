package com.addamsestates.branch.repo;

import com.addamsestates.branch.model.InternalServices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InternalServicesRepository extends JpaRepository <InternalServices, Long> {

    List<InternalServices> getByActive(Boolean isActive);

}

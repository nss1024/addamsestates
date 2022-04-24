package com.addamsestates.branch.repo;

import com.addamsestates.branch.model.Documents;
import com.addamsestates.branch.model.Events;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EventsRepository extends JpaRepository<Events, Long> {

    Events findFirstByOrderByEventIdDesc();

    public List<Events> getByEventActive(Boolean isActive);

}

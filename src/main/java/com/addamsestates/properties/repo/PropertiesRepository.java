package com.addamsestates.properties.repo;

import com.addamsestates.properties.model.Properties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PropertiesRepository extends JpaRepository<Properties, Long> {

    public List<Properties> getByAvailabilityAndOffer(Boolean isAvailable, Long offerType);

    public List<Properties> getByAvailability(Boolean isAvailable);

    public List<Properties> getByEmployeeId(Long employeeId);

}

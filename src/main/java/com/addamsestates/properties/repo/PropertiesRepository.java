package com.addamsestates.properties.repo;

import com.addamsestates.properties.model.Properties;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PropertiesRepository extends JpaRepository<Properties, Long> {
}

package com.addamsestates.properties.repo;

import com.addamsestates.properties.model.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PropertyTypeRepository extends JpaRepository<PropertyType, Long> {

    PropertyType getByPropertyType(String propertyType);

}

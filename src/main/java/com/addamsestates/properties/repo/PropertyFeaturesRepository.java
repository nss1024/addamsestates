package com.addamsestates.properties.repo;

import com.addamsestates.properties.model.PropertyFeatures;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PropertyFeaturesRepository extends JpaRepository<PropertyFeatures, Long> {

    PropertyFeatures getBypropertyFeature(String propertyFeature);

}

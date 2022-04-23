package com.addamsestates.properties.service;

import com.addamsestates.properties.model.PropertyFeatures;

import java.util.List;

public interface PropertyFeaturesService {

    List<PropertyFeatures> getAllPropertyFeatures();

    PropertyFeatures getBypropertyFeature(String propertyFeature);

    void addNewPropertyFeature(PropertyFeatures f);

}

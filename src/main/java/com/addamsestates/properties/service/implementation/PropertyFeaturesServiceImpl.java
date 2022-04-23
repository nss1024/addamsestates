package com.addamsestates.properties.service.implementation;

import com.addamsestates.properties.model.PropertyFeatures;
import com.addamsestates.properties.repo.PropertyFeaturesRepository;
import com.addamsestates.properties.service.PropertyFeaturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyFeaturesServiceImpl implements PropertyFeaturesService {


    @Autowired
    PropertyFeaturesRepository propertyFeaturesRepository;

    @Override
    public List<PropertyFeatures> getAllPropertyFeatures() {
        return propertyFeaturesRepository.findAll();
    }

    @Override
    public PropertyFeatures getBypropertyFeature(String propertyFeature) {
        return propertyFeaturesRepository.getBypropertyFeature(propertyFeature);
    }

    @Override
    public void addNewPropertyFeature(PropertyFeatures f) {
        propertyFeaturesRepository.save(f);
    }
}

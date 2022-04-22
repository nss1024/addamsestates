package com.addamsestates.properties.service.implementation;

import com.addamsestates.properties.model.PropertyType;
import com.addamsestates.properties.repo.PropertyTypeRepository;
import com.addamsestates.properties.service.PropertyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PropertyTypeServiceImpl implements PropertyTypeService {

    @Autowired
    PropertyTypeRepository propertyTypeRepository;

    @Override
    public List<PropertyType> GetAllpropertyTypes() {
        return propertyTypeRepository.findAll();
    }

    @Override
    public PropertyType getByPropertyType(String propertyType) {
        return propertyTypeRepository.getByPropertyType(propertyType);
    }
}

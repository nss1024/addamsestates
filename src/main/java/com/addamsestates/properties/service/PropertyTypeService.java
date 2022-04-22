package com.addamsestates.properties.service;

import com.addamsestates.properties.model.PropertyType;

import java.util.List;

public interface PropertyTypeService {

    List<PropertyType> GetAllpropertyTypes();

    PropertyType getByPropertyType(String propertyType);

}

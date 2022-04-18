package com.addamsestates.properties.service;

import com.addamsestates.properties.model.Properties;

import java.util.List;

public interface PropertiesService {

    public List<Properties> findAllProperties();

    public List<Properties> findAllActivePropertiesForSale();

    public List<Properties> findAllActivePropertiesToRent();

    public List<Properties> findAllActivePropertiesForAuction();

    public List<Properties> findAllActivePropertiesSharedOwnership();

    public List<Properties> findAllActivePropertiesOtherOfferType(Long offerTypeCode);

    public List<Properties> findAllNonActiveProperties();

    public Properties findPropertyById(Long id);

    public List<Properties> getByAvailability(Boolean isAvailable);

    public List<Properties> getByEmployeeId(Long id);

}

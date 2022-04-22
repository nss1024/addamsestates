package com.addamsestates.properties.service.implementation;

import com.addamsestates.properties.model.Properties;
import com.addamsestates.properties.repo.PropertiesRepository;
import com.addamsestates.properties.service.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertiesServiceImpl implements PropertiesService {

    @Autowired
    PropertiesRepository propertiesRepository;

    @Override
    public List<Properties> findAllProperties() {
        return propertiesRepository.findAll();
    }

    @Override
    public List<Properties> findAllActivePropertiesForSale() {
        return propertiesRepository.getByAvailabilityAndOffer(true,1L);
    }

    @Override
    public List<Properties> findAllActivePropertiesToRent() {
        return propertiesRepository.getByAvailabilityAndOffer(true,2L);
    }

    @Override
    public List<Properties> findAllActivePropertiesForAuction() {
        return propertiesRepository.getByAvailabilityAndOffer(true,4L);
    }

    @Override
    public List<Properties> findAllActivePropertiesSharedOwnership() {
        return propertiesRepository.getByAvailabilityAndOffer(true,3L);
    }

    @Override
    public List<Properties> findAllActivePropertiesOtherOfferType(Long offerTypeCode) {
        return propertiesRepository.getByAvailabilityAndOffer(true,offerTypeCode);
    }

    @Override
    public List<Properties> findAllNonActiveProperties() {
        return propertiesRepository.getByAvailability(false);
    }

    @Override
    public Properties findPropertyById(Long id) {
        return propertiesRepository.getById(id);
    }

    @Override
    public List<Properties> getByAvailability(Boolean isAvailable) {
        return propertiesRepository.getByAvailability(isAvailable);
    }

    @Override
    public List<Properties> getByEmployeeId(Long id) {
        return propertiesRepository.getByEmployeeId(id);
    }

    @Override
    public List<Properties> getByEmployeeIdAndAvailability(Long employeeId) {
        return propertiesRepository.getByEmployeeIdAndAvailability(employeeId,true);
    }

    public void updatePropertyDetails(Properties p){
        propertiesRepository.save(p);
    }
}

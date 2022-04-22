package com.addamsestates.properties.service.implementation;

import com.addamsestates.properties.model.PropertyOffer;
import com.addamsestates.properties.model.PropertyType;
import com.addamsestates.properties.repo.PropertyOfferRepository;
import com.addamsestates.properties.repo.PropertyTypeRepository;
import com.addamsestates.properties.service.PropertyOfferService;
import com.addamsestates.properties.service.PropertyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyOfferTypeImpl implements PropertyOfferService {

    @Autowired
    PropertyOfferRepository propertyOfferRepository;
    @Override
    public List<PropertyOffer> getAllPropertyOfferTypes() {
        return propertyOfferRepository.findAll();
    }

    @Override
    public PropertyOffer getByPropertyOffer(String propertyOffer) {
        return propertyOfferRepository.getByPropertyOffer(propertyOffer);
    }
}

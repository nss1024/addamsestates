package com.addamsestates.properties.service;

import com.addamsestates.properties.model.PropertyOffer;

import java.util.List;

public interface PropertyOfferService {

    List<PropertyOffer> getAllPropertyOfferTypes ();

    PropertyOffer getByPropertyOffer(String propertyOffer);

}

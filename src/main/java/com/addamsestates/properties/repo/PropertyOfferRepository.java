package com.addamsestates.properties.repo;

import com.addamsestates.properties.model.PropertyOffer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PropertyOfferRepository extends JpaRepository<PropertyOffer, Long> {

    PropertyOffer getByPropertyOffer(String propertyOffer);

}

package com.addamsestates.properties.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Entity
@Table(name="property_offer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyOffer {

    @Id
    @GeneratedValue()
    @Column(name = "property_offer_id", updatable = false, nullable = false)
    private Long propertyOfferId;
    @Column(name="property_offer")
    private String propertyOffer;
    @Column(name="property_offer_description")
    private String propertyOfferDescription;

}

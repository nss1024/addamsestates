package com.addamsestates.properties.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Entity
@Table(name="property_features")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyFeatures {

    @Id
    @GeneratedValue()
    @Column(name = "property_features_id", updatable = false, nullable = false)
    private Long propertyFeaturesId;
    @Column(name="property_feature")
    private String propertyFeature;
    @Column(name="property_feature_description")
    private String propertyFeatureDescription;


}

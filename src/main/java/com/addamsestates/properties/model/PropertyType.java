package com.addamsestates.properties.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Entity
@Table(name="property_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyType {

    @Id
    @GeneratedValue()

    @Column(name = "property_type_id", updatable = false, nullable = false)
    private Long propertyTypeId;
    @Column(name="property_type")
    private String propertyType;
    @Column(name="property_type_description")
    private String propertyTypeDescription;

}

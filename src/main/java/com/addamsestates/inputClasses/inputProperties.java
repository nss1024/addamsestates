package com.addamsestates.inputClasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class inputProperties {

private Long propertyId;
private String propertyType;
private String propertyOffer;
private String propertyFeature;
private Boolean availability;
private String description;
private Integer bedroomNo;
private String postCode;
private String county;
private Integer price;
private String address;
}

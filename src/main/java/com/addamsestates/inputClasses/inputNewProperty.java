package com.addamsestates.inputClasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class inputNewProperty {

    private Long branchId;
    private Long employeeId;
    private Long ownerId;
    private Long propertyType;
    private Long propertyOffer;
    private Long propertyFeature;
    private Boolean availability;
    private String description;
    private Integer bedroomNo;
    private String postCode;
    private String county;
    private Integer price;
    private String address;

}

package com.addamsestates.inputClasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class inputSellRentProperty {

    //for document creation
    private Long branchId;
    private Long employeeId;
    private Long contractId;

    //for sales
    private Long propertyId;
    private Long ownerId;
    private Long buyerId;


}

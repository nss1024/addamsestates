package com.addamsestates.inputClasses;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class inputEnquiries {


    private Long employeeId;//from submit button
    private String contents; //message
    private String enquiryType;//radio button
    private String enquirerName;//your name field
    private String enquirerContact;//How can we contact you field

}

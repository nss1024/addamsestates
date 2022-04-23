package com.addamsestates.inputClasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class inputImage {

    private String fileName;
    private String fileDescription;
    private String fileUrl;
    private Date createdAt;
    private Long propertyId;


}

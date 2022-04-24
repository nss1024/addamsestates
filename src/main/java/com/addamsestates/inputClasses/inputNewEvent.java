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
public class inputNewEvent {

    private String eventType;
    private String eventName;
    private String eventDescription;
    private String startDate;
    private String endDate;
    private Long branchId;

}

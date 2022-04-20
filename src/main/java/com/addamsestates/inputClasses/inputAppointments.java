package com.addamsestates.inputClasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import javax.persistence.Column;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class inputAppointments {

    private String appointmentWith;
    private String appointmentType;
    private String discussion;
    private String appointmentDate;
    private String appointmentTime;

}

package com.addamsestates.employees.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="appointments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id", updatable = false, nullable = false)
    private Long appointmentId;
    @Column(name="employee_id")
    private Long employeeId;
    @Column(name="appointment_type")
    private String appointmentType;
    @Column(name="appointment_with")
    private String appointmentWith;
    @Column(name="discussion")
    private String discussion;
    @Column(name="completed")
    private Boolean completed;
    @Column(name="appointment_date")
    private Date appointmentDate;
    @Column(name="created_at")
    private Date createdAt;
    @Column(name="appointment_time")
    private String appointmentTime;
}

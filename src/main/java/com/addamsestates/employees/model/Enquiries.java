package com.addamsestates.employees.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="enquiries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enquiries {

    @Id
    @GeneratedValue()
    @Column(name = "enquiry_id", updatable = false, nullable = false)
    private Long enquiryId;
    @Column(name="employee_id")
    private Long employeeId;
    @Column(name="contains")
    private String contains;
    @Column(name="enquiry_type")
    private String enquiryType;
    @Column(name="completed")
    private Boolean completed;
    @Column(name="created_at")
    private Date createdAt;
    @Column(name="enquirer_name")
    private String enquirerName;
    @Column(name="enquirer_contact")
    private String enquirerContact;

}

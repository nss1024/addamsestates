package com.addamsestates.mainPage.model;

import com.addamsestates.employees.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="visible_team")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisibleTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id", updatable = false, nullable = false)
    private Long recordId;
    @Column(name="employee_id")
    private Long employeeId;
    @Column(name="about_me")
    private String aboutMe;
    @Column(name="contact")
    private String contact;
    @Column(name="visible")
    private Boolean visible;
    @Column(name="created_at")
    private Date createdAt;


    @OneToOne(cascade=CascadeType.ALL,orphanRemoval = false, fetch=FetchType.EAGER)
    @JoinColumn(name="employee_id",insertable = false , updatable = false)
    Employee employee;

}

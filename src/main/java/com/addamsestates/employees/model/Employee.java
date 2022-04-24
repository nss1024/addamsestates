package com.addamsestates.employees.model;

import com.addamsestates.users.model.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", updatable = false, nullable = false)
    private Long employeeId;
    @Column(name="user_profile_id")
    private Long userProfileId;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "salary")
    private String salary;
    @Column(name = "address")
    private String address;
    @Column(name = "job_description")
    private String jobDescription;
    @Column(name="created_at")
    private Date createdAt;
    @Column(name="branch_id")
    private Long branchId;


    @OneToOne(cascade=CascadeType.ALL, orphanRemoval = false, fetch=FetchType.EAGER)
    @JoinColumn(name = "user_profile_id", insertable = false , updatable = false)
    UserProfile userProfile;

}

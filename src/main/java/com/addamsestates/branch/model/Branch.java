package com.addamsestates.branch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="branch")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Branch {

    @Id
    @GeneratedValue()
    @Column(name = "branch_id", updatable = false, nullable = false)
    private Long branchId;
    @Column(name="contact_email")
    private String contactEmail;
    @Column(name="contact_number")
    private String contactNumber;
    @Column(name="address")
    private String address;
    @Column(name="bank_details")
    private String bankDetails;
    @Column(name="created_at")
    private Date createdAt;

}

package com.addamsestates.customers.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", updatable = false, nullable = false)
    private Long customerId;
    @Column(name="user_id")
    private Long userId;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="contact_number")
    private String contactNumber;
    @Column(name="created_at")
    private Date createdAt;
    @Column(name="branch_id")
    private Long branchId;

}


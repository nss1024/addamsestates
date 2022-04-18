package com.addamsestates.users.model;

import com.addamsestates.employees.model.Employee;
import com.addamsestates.image.model.UserProfileImages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name="user_profile")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

    @Id
    @GeneratedValue()
    @Column(name = "user_profile_id", updatable = false, nullable = false)
    private Long userProfileId;
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
    @Column(name="permissions")
    private String permissions;
    @Column(name="created_at")
    private Date createdAt;


    @OneToOne (cascade=CascadeType.ALL,orphanRemoval = false, fetch=FetchType.EAGER)
    @JoinColumn(name="user_profile_id")
    private UserProfileImages profilePic;

    @OneToOne
    @JoinColumn(name="user_profile_id")
    private Employee employee;

}

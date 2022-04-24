package com.addamsestates.inputClasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class inputColleague {
    //User
    private String userName;
    private String password;
    private String rePassword;
    //UserProfile
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String permissions;
    //Employee
    private String startDate;
    private String salary;
    private String address;
    private String jobDescription;
    private Long branchId;
    //VisibleTeam
    private String aboutMe;
    private String contact;
    private Boolean visible;
}

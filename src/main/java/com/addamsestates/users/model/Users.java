package com.addamsestates.users.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue()
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name="user_name")
    private String userName;
    @Column(name="password")
    private String password;
    @Column(name="created_at")
    private Date created_at;

    @OneToOne
    @JoinColumn(name="id")
    private UserProfile userProfile;

}

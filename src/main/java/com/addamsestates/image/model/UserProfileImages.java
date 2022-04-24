package com.addamsestates.image.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="user_profile_images")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id", updatable = false, nullable = false)
    private Long fileId;
    @Column(name="user_profile_id")
    private Long userProfileId;
    @Column(name="file_name")
    private String fileName;
    @Column(name="file_description")
    private String fileDescription;
    @Column(name="file_url")
    private String fileUrl;
    @Column(name="created_at")
    private Date createdAt;


}

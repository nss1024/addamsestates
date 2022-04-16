package com.addamsestates.image.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="properties_images")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertiesImages {

    @Id
    @GeneratedValue()
    @Column(name = "file_id", updatable = false, nullable = false)
    private Long fileId;
    @Column(name="property_id")
    private Long propertyId;
    @Column(name="file_name")
    private String fileName;
    @Column(name="file_description")
    private String fileDescription;
    @Column(name="file_url")
    private String fileUrl;
    @Column(name="created_at")
    private Date createdAt;
}

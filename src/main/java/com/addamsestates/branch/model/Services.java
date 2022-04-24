package com.addamsestates.branch.model;

import com.addamsestates.image.model.ServicesImages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="services")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id", updatable = false, nullable = false)
    private Long serviceId;
    @Column(name="branch_id")
    private Long branchId;
    @Column(name="service_name")
    private String serviceName;
    @Column(name="description")
    private String description;
    @Column(name="image")
    private Long image;
    @Column(name="create_date")
    private Date createDate;
    @Column(name="active")
    private Boolean active;
    @Column(name="link")
    private String link;

    @OneToOne(cascade=CascadeType.ALL, orphanRemoval = false, fetch=FetchType.EAGER)
    @JoinColumn(name="service_id",insertable = false , updatable = false)
    ServicesImages serviceImage;

}

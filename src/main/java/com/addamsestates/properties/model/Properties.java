package com.addamsestates.properties.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="properties")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Properties {

    @Id
    @GeneratedValue()
    @Column(name = "service_id", updatable = false, nullable = false)
    private Long propertyId;
    @Column(name="branch_id")
    private Long branchId;
    @Column(name="employee_id")
    private Long employeeId;
    @Column(name="customer_id")
    private Long customerId;
    @Column(name="property_type_id")
    private Long property_type;
    @Column(name="property_features_id")
    private Long property_features;
    @Column(name="property_offer_id")
    private Long offer_type;
    @Column(name="availability")
    private String availability;
    @Column(name="description")
    private String description;
    @Column(name="bedroom_no")
    private String bedroomNo;
    @Column(name="post_code")
    private String postCode;
    @Column(name="county")
    private String county;
    @Column(name="price")
    private String price;
    @Column(name="created_at")
    private Date createdAt;
    @Column(name="profile_picture")
    private String profilePicture;
    @Column(name="address")
    private String address;


}

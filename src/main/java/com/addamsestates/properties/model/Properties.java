package com.addamsestates.properties.model;

import com.addamsestates.image.model.PropertiesImages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="properties")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Properties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_id", updatable = false, nullable = false)
    private Long propertyId;
    @Column(name="branch_id")
    private Long branchId;
    @Column(name="employee_id")
    private Long employeeId;
    @Column(name="customer_id")
    private Long customerId;
    @Column(name="property_type")
    private Long propertyType;
    @Column(name="property_features")
    private Long property_features;
    @Column(name="offer")
    private Long offer;
    @Column(name="availability")
    private Boolean availability;
    @Column(name="description")
    private String description;
    @Column(name="bedroom_no")
    private Integer bedroomNo;
    @Column(name="post_code")
    private String postCode;
    @Column(name="county")
    private String county;
    @Column(name="price")
    private String price;
    @Column(name="created_at")
    private Date createdAt;
    @Column(name="address")
    private String address;

    @OneToOne
    @JoinColumn(name="property_type", insertable = false, updatable = false)
    private PropertyType propertyTypeJoin;

    @OneToOne
    @JoinColumn(name="offer", insertable = false, updatable = false)
    private PropertyOffer propertyOffer;

    @OneToOne
    @JoinColumn(name="property_features", insertable = false, updatable = false)
    private PropertyFeatures propertyFeatures;

    @OneToMany
    @JoinColumn(name="property_id", insertable = false, updatable = false)
    private List<PropertiesImages> propertyImages;

}

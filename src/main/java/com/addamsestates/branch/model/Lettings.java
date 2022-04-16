package com.addamsestates.branch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="lettings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lettings {

    @Id
    @GeneratedValue()
    @Column(name = "record_id", updatable = false, nullable = false)
    private Long recordId;
    @Column(name="branch_id")
    private Long branchId;
    @Column(name="employee_id")
    private Long employeeId;
    @Column(name="property_id")
    private Long propertyId;
    @Column(name="owner_id")
    private Long ownerId;
    @Column(name="buyer_id")
    private Long buyerId;
    @Column(name="document_id")
    private Long documentId;
    @Column(name="created_at")
    private Date createdAt;

}

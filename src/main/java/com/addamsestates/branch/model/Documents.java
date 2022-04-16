package com.addamsestates.branch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="documents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Documents {

    @Id
    @GeneratedValue()
    @Column(name = "document_id", updatable = false, nullable = false)
    private Long documentId;
    @Column(name="branch_id")
    private Long branchId;
    @Column(name="employee_id")
    private Long employeeId;
    @Column(name="contract_id")
    private Long contractId;
    @Column(name="created_at")
    private Date createdAt;

}

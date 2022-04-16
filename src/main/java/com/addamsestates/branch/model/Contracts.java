package com.addamsestates.branch.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="contracts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contracts {

    @Id
    @GeneratedValue()
    @Column(name = "branch_id", updatable = false, nullable = false)
    private Long contractId;
    @Column(name="file_name")
    private String fileName;
    @Column(name="contract_description")
    private String contractDescription;
    @Column(name="contract_url")
    private String contractUrl;
    @Column(name="created_at")
    private Date createdAt;

}

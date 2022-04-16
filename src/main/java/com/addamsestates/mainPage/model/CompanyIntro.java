package com.addamsestates.mainPage.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="company_intro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyIntro {
    @Id
    @GeneratedValue()
    @Column(name = "record_id", updatable = false, nullable = false)
    private Long recordId;
    @Column(name = "branch_id")
    private Long branchId;
    @Column(name = "contents")
    private String contents;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "active")
    private Boolean active;


}

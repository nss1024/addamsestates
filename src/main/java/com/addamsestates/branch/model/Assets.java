package com.addamsestates.branch.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="assets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assets {

    @Id
    @GeneratedValue()
    @Column(name = "asset_id", updatable = false, nullable = false)
    private Long assetId;
    @Column(name="branch_id")
    private Long branchId;
    @Column(name="asset_description")
    private String assetDescription;
    @Column(name="purchase_date")
    private Date purchaseDate;
    @Column(name="status")
    private String status;

}

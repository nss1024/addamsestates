package com.addamsestates.branch.model;

import com.addamsestates.image.model.InternalServicesImages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="internal_services")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InternalServices {

    @Id
    @GeneratedValue()
    @Column(name = "iservice_id", updatable = false, nullable = false)
    private Long serviceId;
    @Column(name="branch_id")
    private Long branchId;
    @Column(name="service_name")
    private String serviceName;
    @Column(name="description")
    private String description;
    @Column(name="created_at")
    private Date createDate;
    @Column(name="active")
    private Boolean active;
    @Column(name="link")
    private String link;

    @OneToOne
    @JoinColumn(name="iservice_id", referencedColumnName = "intserviceid")
    private InternalServicesImages images;


}

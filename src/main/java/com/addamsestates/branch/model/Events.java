package com.addamsestates.branch.model;

import com.addamsestates.image.model.EventsImages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="events")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Events {

    @Id
    @GeneratedValue()
    @Column(name = "event_id", updatable = false, nullable = false)
    private Long eventId;
    @Column(name="event_type")
    private String eventType;
    @Column(name="event_Name")
    private String eventName;
    @Column(name="event_description")
    private String eventDescription;
    @Column(name="event_active")
    private Boolean eventActive;
    @Column(name="start_date")
    private Date startDate;
    @Column(name="end_date")
    private Date endDate;
    @Column(name="create_date")
    private Date createdAt;
    @Column(name="branch_id")
    private Long branchId;

    @OneToOne(cascade=CascadeType.ALL, orphanRemoval = false, fetch=FetchType.EAGER)
    @JoinColumn(name="event_id")
    private EventsImages eventImage;

}

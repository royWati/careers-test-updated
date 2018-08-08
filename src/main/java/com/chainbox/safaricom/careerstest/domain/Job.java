package com.chainbox.safaricom.careerstest.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "jobs")
public class Job extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "job_name")
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "job_type_id", nullable = false)
    private JobType jobType;

    @Column(name = "years_of_experience")
    private String yearsOfExperience;
    private String status;

    @Column(name = "interview_start_date")
    private ZonedDateTime interviewStartDate;

    @Column(name = "interview_end_time")
    private ZonedDateTime interviewEndTime;
}

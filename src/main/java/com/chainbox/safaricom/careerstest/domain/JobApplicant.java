package com.chainbox.safaricom.careerstest.domain;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "job_applicants")
public class JobApplicant extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "education_level")
    private String educationLevel; //todo should be an enum
    @Column(name = "years_of_experience")
    private int yearsOfExperience;

    @ManyToMany
    @JoinTable(name = "job_applicant_jobs")
    private List<Job> jobs = new ArrayList<>();

}

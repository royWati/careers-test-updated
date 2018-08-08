package com.chainbox.safaricom.careerstest.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "job_applicants")
public class JobApplicant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
    private List<Job> jobs=new ArrayList<>();

}

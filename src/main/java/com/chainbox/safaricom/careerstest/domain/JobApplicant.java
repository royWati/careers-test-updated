package com.chainbox.safaricom.careerstest.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "job_applicants")
public class JobApplicant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "education_level")
    private String educationLevel;
    @Column(name = "years_of_experience")
    private int yearsOfExperience;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private Set<Job> jobsApplied;

}

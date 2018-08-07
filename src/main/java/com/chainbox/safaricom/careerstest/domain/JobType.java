package com.chainbox.safaricom.careerstest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "job_types")
public class JobType extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;

    @JsonIgnore
    @OneToMany(mappedBy = "jobType", fetch = FetchType.LAZY)
    private List<Job> jobs = new ArrayList<>();

    public void addJob(Job job) {
        this.jobs.add(job);
    }
}

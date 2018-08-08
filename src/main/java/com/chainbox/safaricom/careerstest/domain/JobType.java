package com.chainbox.safaricom.careerstest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "job_types")
public class JobType extends BaseEntity {

    private String name;
    private String code;

    @JsonIgnore
    @OneToMany(mappedBy = "jobType", fetch = FetchType.LAZY)
    private List<Job> jobs = new ArrayList<>();

    public void addJob(Job job) {
        this.jobs.add(job);
    }
}

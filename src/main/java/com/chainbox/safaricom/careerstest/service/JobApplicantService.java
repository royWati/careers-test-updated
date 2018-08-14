package com.chainbox.safaricom.careerstest.service;


import com.chainbox.safaricom.careerstest.domain.Job;
import com.chainbox.safaricom.careerstest.domain.JobApplicant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface JobApplicantService {

    JobApplicant create(JobApplicant jobApplicant);

    Page<JobApplicant> fetchAll(Pageable pageable);

    JobApplicant fetchOneById(UUID id);

    JobApplicant update(UUID id, JobApplicant job);
    JobApplicant update(UUID id, Job job);


    void delete(UUID id);

    List<JobApplicant> jobTotal(UUID id);

    JobApplicant deSelectJob(UUID id,UUID jobId);


}

package com.chainbox.safaricom.careerstest.service;


import com.chainbox.safaricom.careerstest.domain.JobApplicant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface JobApplicantService {

    JobApplicant create(JobApplicant jobApplicant);

    Page<JobApplicant> fetchAll(Pageable pageable);

    JobApplicant fetchOneById(UUID id);

    JobApplicant update(UUID id, JobApplicant job);

    void delete(UUID id);
}

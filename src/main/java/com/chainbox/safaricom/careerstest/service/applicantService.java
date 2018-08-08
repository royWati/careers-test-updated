package com.chainbox.safaricom.careerstest.service;


import com.chainbox.safaricom.careerstest.domain.JobApplicant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface applicantService {

    JobApplicant create(JobApplicant jobApplicant);

    Page<JobApplicant> fetchAll(Pageable pageable);

    JobApplicant fetchOneById(Long id);

    JobApplicant update(Long id, JobApplicant job);

    void delete(Long id);
}

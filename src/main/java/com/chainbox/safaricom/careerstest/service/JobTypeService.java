package com.chainbox.safaricom.careerstest.service;

import com.chainbox.safaricom.careerstest.domain.JobType;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JobTypeService {
    JobType create(JobType jobType);

    JobType fetchById(Long id);

    Page<JobType> fetchAll(Pageable pageable);

    JobType update(Long id, JobType jobType);

    void delete(Long id);
}

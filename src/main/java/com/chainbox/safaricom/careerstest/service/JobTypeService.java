package com.chainbox.safaricom.careerstest.service;

import com.chainbox.safaricom.careerstest.domain.JobType;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface JobTypeService {
    JobType create(JobType jobType);

    JobType fetchById(UUID id);

    Page<JobType> fetchAll(Pageable pageable);

    JobType update(UUID id, JobType jobType);

    void delete(UUID id);
}

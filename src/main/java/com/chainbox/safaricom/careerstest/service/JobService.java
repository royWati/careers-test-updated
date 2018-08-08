package com.chainbox.safaricom.careerstest.service;

import com.chainbox.safaricom.careerstest.domain.Job;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface JobService {

    Job create(Job job);

    Page<Job> fetchAll(Pageable pageable);

    Job fetchOneById(UUID id);

    Job update(UUID id, Job job);

    void delete(UUID id);

}

package com.chainbox.safaricom.careerstest.service;

import com.chainbox.safaricom.careerstest.domain.Job;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JobService {

    Job create(Job job);
    Page<Job> fetchAll(Pageable pageable);
    Job fetchOneById(Long id);
    Job update(Long id,Job job);
    void delete(Long id);

}

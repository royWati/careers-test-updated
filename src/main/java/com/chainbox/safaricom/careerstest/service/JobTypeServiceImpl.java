package com.chainbox.safaricom.careerstest.service;

import com.chainbox.safaricom.careerstest.domain.JobType;
import com.chainbox.safaricom.careerstest.repository.JobTypeRepository;
import com.chainbox.safaricom.careerstest.utils.exception.ResourceNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class JobTypeServiceImpl implements JobTypeService {

    private final JobTypeRepository jobTypeRepository;

    public JobTypeServiceImpl(JobTypeRepository jobTypeRepository) {
        this.jobTypeRepository = jobTypeRepository;
    }

    @Override
    public JobType create(JobType jobType) {
        //  jobType.setUuid(generate());
        return jobTypeRepository.save(jobType);
    }

    @Override
    public JobType fetchById(UUID id) {
        return validate(id);
    }

    @Override
    public Page<JobType> fetchAll(Pageable pageable) {
        return jobTypeRepository.findAll(pageable);
    }

    @Override
    public JobType update(UUID id, JobType jobType) {
        validate(id);
        return jobTypeRepository.save(jobType);
    }

    @Override
    public void delete(UUID id) {
        jobTypeRepository.findById(id).ifPresent(jobType -> {
            jobType.setDeleted(true);
            jobTypeRepository.save(jobType);
        });
    }

    private JobType validate(UUID id) {
        return jobTypeRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}

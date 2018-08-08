package com.chainbox.safaricom.careerstest.service;

import com.chainbox.safaricom.careerstest.domain.Job;
import com.chainbox.safaricom.careerstest.repository.JobRepository;
import com.chainbox.safaricom.careerstest.utils.exception.BadRequestException;
import com.chainbox.safaricom.careerstest.utils.exception.ResourceNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Job create(Job job) {
        if (null == job.getJobType()) {
            throw new BadRequestException();
        }

        //   job.setUuid(generate());
        return jobRepository.save(job);
    }

    @Override
    public Page<Job> fetchAll(Pageable pageable) {
        return jobRepository.findAll(pageable);
    }

    @Override
    public Job fetchOneById(UUID id) {
        return validate(id);
    }

    @Override
    public Job update(UUID id, Job job) {
        validate(id);

        return jobRepository.save(job);
    }

    @Override
    public void delete(UUID id) {

        jobRepository.findById(id).ifPresent(job -> {
            job.setDeleted(true);

            jobRepository.save(job);
        });

    }

    private Job validate(UUID id) {
        return jobRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

}

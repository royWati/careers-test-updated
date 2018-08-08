package com.chainbox.safaricom.careerstest.service;

import com.chainbox.safaricom.careerstest.domain.JobApplicant;
import com.chainbox.safaricom.careerstest.repository.JobApplicantRepository;
import com.chainbox.safaricom.careerstest.utils.exception.BadRequestException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class JobApplicantServiceImpl implements JobApplicantService {

    private final JobApplicantRepository applicantsRepo;

    public JobApplicantServiceImpl(JobApplicantRepository applicantsRepo) {
        this.applicantsRepo = applicantsRepo;
    }

    @Override
    public JobApplicant create(JobApplicant jobApplicant) {

        if (null == jobApplicant.getJobs()) throw new BadRequestException();
        //    jobApplicant.setUuid(generate());
        return applicantsRepo.save(jobApplicant);
    }

    @Override
    public Page<JobApplicant> fetchAll(Pageable pageable) {
        return applicantsRepo.findAll(pageable);

    }

    @Override
    public JobApplicant fetchOneById(UUID id) {
        return validate(id);
    }

    @Override
    public JobApplicant update(UUID id, JobApplicant job) {
        validate(id);
        return applicantsRepo.save(job);
    }

    @Override
    public void delete(UUID id) {
        applicantsRepo.findById(id).ifPresent(jobApplicant -> {
            jobApplicant.setDeleted(true);

            applicantsRepo.save(jobApplicant);
        });
    }

    private JobApplicant validate(UUID id) {
        return applicantsRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }


}

package com.chainbox.safaricom.careerstest.service;

import com.chainbox.safaricom.careerstest.domain.JobApplicant;
import com.chainbox.safaricom.careerstest.domain.UuidGenerator;
import com.chainbox.safaricom.careerstest.repository.applicantsRepository;
import com.chainbox.safaricom.careerstest.utils.exception.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class applicantServiceImpl implements applicantService {

    private final applicantsRepository applicantsRepo;

    public applicantServiceImpl(applicantsRepository applicantsRepo) {
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
    public JobApplicant fetchOneById(Long id) {
        return validate(id);
    }

    @Override
    public JobApplicant update(Long id, JobApplicant job) {
        validate(id);
        return applicantsRepo.save(job);
    }

    @Override
    public void delete(Long id) {
        applicantsRepo.findById(id).ifPresent(jobApplicant -> {
            jobApplicant.setDeleted(true);

            applicantsRepo.save(jobApplicant);
        });
    }

    private JobApplicant validate(Long id) {
        return applicantsRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }



}

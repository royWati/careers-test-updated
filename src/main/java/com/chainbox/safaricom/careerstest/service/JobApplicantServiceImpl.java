package com.chainbox.safaricom.careerstest.service;

import com.chainbox.safaricom.careerstest.domain.Job;
import com.chainbox.safaricom.careerstest.domain.JobApplicant;
import com.chainbox.safaricom.careerstest.repository.JobApplicantRepository;
import com.chainbox.safaricom.careerstest.utils.exception.BadRequestException;

import com.chainbox.safaricom.careerstest.utils.exception.JobConflictException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class JobApplicantServiceImpl implements JobApplicantService {

    private final JobApplicantRepository applicantsRepo;
    private final JobService jobService;

    public JobApplicantServiceImpl(JobApplicantRepository applicantsRepo, JobService jobService) {
        this.applicantsRepo = applicantsRepo;
        this.jobService = jobService;
    }

    @Override
    public JobApplicant create(JobApplicant jobApplicant) {

        if (null == jobApplicant.getJobs()) throw new BadRequestException();
        //    jobApplicant.setUuid(generate());
       // validateStartTime(jobApplicant);
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
       // validateStartTime(job);
        return applicantsRepo.save(job);
    }

    @Override
    public JobApplicant update(UUID id, Job job) {
        validate(id);
       List<Job> jobs=new ArrayList<>();
       applicantsRepo.findById(id).ifPresent(jobApplicant -> {
         jobs.addAll(jobApplicant.getJobs());
         for(Job jobs1:jobs){
           if (jobs1.getInterviewStartDate().isEqual(job.getInterviewStartDate()))
               throw new JobConflictException();
         }
         jobs.add(job);
         jobApplicant.setJobs(jobs);
         applicantsRepo.save(jobApplicant);
       });
        return validate(id);
    }

    @Override
    public void delete(UUID id) {
        applicantsRepo.findById(id).ifPresent(jobApplicant -> {
            jobApplicant.setDeleted(true);

            applicantsRepo.save(jobApplicant);
        });
    }

    @Override
    public List<JobApplicant> jobTotal(UUID id) {
        List<JobApplicant> applicants=new ArrayList<>();
        applicantsRepo.findAll().forEach(applicants::add);
        List<JobApplicant> filter=applicants.stream().
                filter(jobApplicant -> jobApplicant.getJobs().contains(jobService.fetchOneById(id))).collect(Collectors.toList());
        return filter;
    }

    private JobApplicant validate(UUID id) {
        return applicantsRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public JobApplicant deSelectJob(UUID id,UUID jobId){
        applicantsRepo.findById(id).ifPresent(jobApplicant -> {
            jobApplicant.getJobs().remove(jobService.fetchOneById(jobId));

            applicantsRepo.save(jobApplicant);
        });

        return validate(id);
    }


}

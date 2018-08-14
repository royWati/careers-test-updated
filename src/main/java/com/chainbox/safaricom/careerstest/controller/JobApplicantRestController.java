package com.chainbox.safaricom.careerstest.controller;


import com.chainbox.safaricom.careerstest.domain.Job;
import com.chainbox.safaricom.careerstest.domain.JobApplicant;
import com.chainbox.safaricom.careerstest.service.JobApplicantService;

import com.chainbox.safaricom.careerstest.service.JobService;
import com.chainbox.safaricom.careerstest.utils.exception.MaximumJobsAppliedExeption;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/applicants")
public class JobApplicantRestController {

    private final JobApplicantService service;
    private final JobService jobService;

    public JobApplicantRestController(JobApplicantService service, JobService jobService) {
        this.service = service;
        this.jobService = jobService;
    }

    @PostMapping
    public JobApplicant create(@RequestBody JobApplicant jobApplicant) {
        if (jobApplicant.getJobs().size()>3) throw new MaximumJobsAppliedExeption();
        return service.create(jobApplicant);
    }

    @GetMapping
    public Page<JobApplicant> getAllApplicants(Pageable pageable) {
        return service.fetchAll(pageable);
    }
    @DeleteMapping("/{applicantId}")
    public void deleteJob(@PathVariable UUID applicantId) {
        service.delete(applicantId);
    }

    @GetMapping("/{applicantId}")
    public JobApplicant fetchOneApplicant(@PathVariable UUID applicantId) {
        return service.fetchOneById(applicantId);
    }

    public void checkJobLimit(UUID jobId){
           if(service.jobTotal(jobId).size()>20) throw new MaximumJobsAppliedExeption();
    }
    @PutMapping("/{applicantId}/addjob/{jobId}")
    public JobApplicant updateJob(@PathVariable UUID applicantId, @PathVariable UUID jobId) {
        checkJobLimit(jobId);
        return service.update(applicantId, jobService.fetchOneById(jobId));
    }

    @PutMapping("/{applicantId}")
    public JobApplicant update(@PathVariable UUID applicantId, @RequestBody JobApplicant applicant) {
        return service.update(applicantId, applicant);
    }

    @GetMapping("/view/{jobId}")
    public List<JobApplicant> viewJobApplicants(@PathVariable UUID jobId){
        return service.jobTotal(jobId);
    }

    @PutMapping("/{applicationId}/deselect/{jobId}")
    public JobApplicant deSelectJob(@PathVariable UUID applicationId, @PathVariable UUID jobId){

       return service.deSelectJob(applicationId,jobId);
    }

}

package com.chainbox.safaricom.careerstest.controller;


import com.chainbox.safaricom.careerstest.domain.JobApplicant;
import com.chainbox.safaricom.careerstest.service.JobApplicantService;

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

import java.util.UUID;

@RestController
@RequestMapping("/applicants")
public class JobApplicantRestController {

    private final JobApplicantService service;

    public JobApplicantRestController(JobApplicantService service) {
        this.service = service;
    }

    @PostMapping
    public JobApplicant create(@RequestBody JobApplicant jobApplicant) {
        return service.create(jobApplicant);
    }

    @GetMapping
    public Page<JobApplicant> getAllApplicants(Pageable pageable) {
        return service.fetchAll(pageable);
    }

    @PutMapping("/{applicantId}")
    public JobApplicant updateJob(@PathVariable UUID applicantId, @RequestBody JobApplicant applicant) {
        return service.update(applicantId, applicant);
    }

    @DeleteMapping("/{applicantId}")
    public void deleteJob(@PathVariable UUID applicantId) {
        service.delete(applicantId);
    }

    @GetMapping("/{applicantId}")
    public JobApplicant fetchOneApplicant(@PathVariable UUID applicantId) {
        return service.fetchOneById(applicantId);
    }

}

package com.chainbox.safaricom.careerstest.controller;


import com.chainbox.safaricom.careerstest.domain.JobApplicant;
import com.chainbox.safaricom.careerstest.service.applicantService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/applicants")
public class JobApplicantsRestController {

    private final applicantService service;

    public JobApplicantsRestController(applicantService service) {
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
    public JobApplicant updateJob(@PathVariable Long applicantId, @RequestBody JobApplicant applicant) {
        return service.update(applicantId, applicant);
    }

    @DeleteMapping("/{applicantId}")
    public void deleteJob(@PathVariable Long applicantId) {
        service.delete(applicantId);
    }

    @GetMapping("/{applicantId}")
    public JobApplicant fetchOneApplicant(@PathVariable Long applicantId) {
        return service.fetchOneById(applicantId);
    }

}

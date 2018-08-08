package com.chainbox.safaricom.careerstest.controller;


import com.chainbox.safaricom.careerstest.domain.Job;
import com.chainbox.safaricom.careerstest.service.JobService;

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

@RequestMapping("/jobs")
public class JobRestController {


    private final JobService jobService;

    public JobRestController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public Job create(@RequestBody Job job) {
        return jobService.create(job);
    }

    @GetMapping
    public Page<Job> fetchAll(Pageable pageable) {
        return jobService.fetchAll(pageable);
    }

    @PutMapping("/{jobId}")
    public Job updateJob(@PathVariable UUID jobId, @RequestBody Job job) {
        return jobService.update(jobId, job);
    }

    @DeleteMapping("/{jobId}")

    public void deleteJob(@PathVariable UUID jobId) {
        jobService.delete(jobId);
    }

    @GetMapping("/{jobId}")

    public Job fetchOneJob(@PathVariable UUID jobId) {
        return jobService.fetchOneById(jobId);
    }

}

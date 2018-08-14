package com.chainbox.safaricom.careerstest.controller;


import com.chainbox.safaricom.careerstest.domain.Job;
import com.chainbox.safaricom.careerstest.service.JobService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/")
    public List<Job> search(@RequestParam(value = "search") String search){

        return jobService.search(search);
    }
}

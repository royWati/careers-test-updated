package com.chainbox.safaricom.careerstest.controller;


import com.chainbox.safaricom.careerstest.domain.Job;
import com.chainbox.safaricom.careerstest.service.JobService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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
    public Job updateJob(@PathVariable Long jobId, @RequestBody Job job) {
        return jobService.update(jobId, job);
    }

    @DeleteMapping("/{jobId}")

    public void deleteJob(@PathVariable Long jobId) {
        jobService.delete(jobId);
    }

    @GetMapping("/{jobId}")

    public Job fetchOneJob(@PathVariable Long jobId) {
        return jobService.fetchOneById(jobId);
    }

}

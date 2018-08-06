package com.chainbox.safaricom.careerstest.controller;

import com.chainbox.safaricom.careerstest.domain.JobType;
import com.chainbox.safaricom.careerstest.service.JobTypeService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobTypes")
public class JobTypeRestController {

    private final JobTypeService jobTypeService;

    public JobTypeRestController(JobTypeService jobTypeService) {
        this.jobTypeService = jobTypeService;
    }

    @PostMapping
    public JobType create(@RequestBody JobType jobType) {
        return jobTypeService.create(jobType);
    }

    @GetMapping
    public Page<JobType> fetchAll(@PageableDefault(sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        return jobTypeService.fetchAll(pageable);
    }

    @GetMapping("/{jobTypeId}")
    public JobType fetchOne(@PathVariable Long jobTypeId) {
        return jobTypeService.fetchById(jobTypeId);
    }

    @PutMapping("/{jobTypeId}")
    public JobType update(@PathVariable Long jobTypeId, @RequestBody JobType jobType) {
        return jobTypeService.update(jobTypeId, jobType);
    }

    @DeleteMapping("/{jobTypeId}")
    public void delete(@PathVariable Long jobTypeId) {
        jobTypeService.delete(jobTypeId);
    }
}

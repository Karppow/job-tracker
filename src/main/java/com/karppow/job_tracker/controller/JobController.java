package com.karppow.job_tracker.controller;

import com.karppow.job_tracker.dto.JobRequest;
import com.karppow.job_tracker.dto.JobResponse;
import com.karppow.job_tracker.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public JobResponse createJob(
            @RequestBody JobRequest request
            ) {
        Long userId = 1L; // временно
        return jobService.createJob(request, userId);
    }

    @GetMapping
    public List<JobResponse> getJobs() {
        Long userId = 1L; // временно
        return jobService.getUserJobs(userId);
    }

    @GetMapping("/{id}")
    public JobResponse getJob(@PathVariable Long id) {
        return jobService.getJob(id);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
    }
}

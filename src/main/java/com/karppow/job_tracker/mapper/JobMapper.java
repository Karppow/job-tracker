package com.karppow.job_tracker.mapper;

import com.karppow.job_tracker.dto.JobResponse;
import com.karppow.job_tracker.entity.Job;

public class JobMapper {

    public static JobResponse toResponse(Job job) {

        JobResponse response = new JobResponse();

        response.setId(job.getId());
        response.setCompany(job.getCompany());
        response.setPosition(job.getPosition());
        response.setStatus(job.getStatus());
        response.setCreatedAt(job.getCreatedAt());

        return response;
    }
}

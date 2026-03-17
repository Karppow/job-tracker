package com.karppow.job_tracker.service;

import com.karppow.job_tracker.dto.JobRequest;
import com.karppow.job_tracker.dto.JobResponse;
import com.karppow.job_tracker.entity.Job;
import com.karppow.job_tracker.entity.JobStatus;
import com.karppow.job_tracker.entity.User;
import com.karppow.job_tracker.mapper.JobMapper;
import com.karppow.job_tracker.repository.JobRepository;
import com.karppow.job_tracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;
    private final UserRepository userRepository;

    public JobService (JobRepository jobRepository, UserRepository userRepository){
        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
    }

    public JobResponse createJob(JobRequest request, Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow();

        Job job = new Job();
        job.setCompany(request.getCompany());
        job.setPosition(request.getPosition());
        job.setStatus(JobStatus.APPLIED);
        job.setCreatedAt(LocalDateTime.now());
        job.setUser(user);

        Job savedJob = jobRepository.save(job);

        return JobMapper.toResponse(savedJob);
    }

    public List<JobResponse> getUserJobs(Long userId) {

        return jobRepository.findByUserId(userId)
                .stream()
                .map(JobMapper::toResponse)
                .toList();
    }

    public JobResponse getJob(Long id) {

        Job job = jobRepository.findById(id)
                .orElseThrow();

        return JobMapper.toResponse(job);
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}

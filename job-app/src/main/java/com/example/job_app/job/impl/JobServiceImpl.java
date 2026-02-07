package com.example.job_app.job.impl;

import com.example.job_app.job.Job;
import com.example.job_app.job.JobRepository;
import com.example.job_app.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    // private List<Job> jobs = new ArrayList<>();
    // private Long nextId = 1L;

    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobByID(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteJob(Long id) {
        if (!jobRepository.existsById(id)) {
            throw new RuntimeException("Job not found");
        }
        jobRepository.deleteById(id);
    }

    @Override
    public void updateJob(Long id, Job job) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job existingJob = jobOptional.get();
            existingJob.setTitle(job.getTitle());
            existingJob.setDescription(job.getDescription());
            existingJob.setMinSalary(job.getMinSalary());
            existingJob.setMaxSalary(job.getMaxSalary());
            existingJob.setLocation(job.getLocation());
            jobRepository.save(existingJob);
        }
    }
}

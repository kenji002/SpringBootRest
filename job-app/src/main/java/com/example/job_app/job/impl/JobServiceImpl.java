package com.example.job_app.job.impl;

import com.example.job_app.job.Job;
import com.example.job_app.job.JobRepository;
import com.example.job_app.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public boolean createJob(Job job) {
        if (job.getId() != null && jobRepository.existsById(job.getId())) {
            return false;
        }
        jobRepository.save(job);
        return true;
    }

    @Override
    public Job getJobByID(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJob(Long id) {
        if (!jobRepository.existsById(id)) {
            return false;
        }
        jobRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateJob(Long id, Job job) {
        if (!jobRepository.existsById(id)) {
            return false;
        }
        Job existingJob = jobRepository.findById(id).get();
        existingJob.setTitle(job.getTitle());
        existingJob.setDescription(job.getDescription());
        existingJob.setMinSalary(job.getMinSalary());
        existingJob.setMaxSalary(job.getMaxSalary());
        existingJob.setLocation(job.getLocation());
        jobRepository.save(existingJob);
        return true;
    }
}

package com.example.job_app.job.impl;

import com.example.job_app.job.Job;
import com.example.job_app.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L; // IDの初期値を1に設定

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getJobByID(Long id) {
        for (Job job : jobs) {
            if (id.equals(job.getId())) {
                return job;
            }
        }
        return null;
    }

    @Override
    public void deleteJob(Long id) {
        jobs.removeIf(job -> job.getId().equals(id));
    }

    @Override
    public void updateJob(Long id, Job job) {
        Job existingJob = getJobByID(id);
        existingJob.setTitle(job.getTitle());
        existingJob.setDescription(job.getDescription());
        existingJob.setMinSalary(job.getMinSalary());
        existingJob.setMaxSalary(job.getMaxSalary());
        existingJob.setLocation(job.getLocation());
    }
}

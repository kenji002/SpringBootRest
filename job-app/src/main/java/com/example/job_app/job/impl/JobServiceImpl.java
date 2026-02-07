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

}

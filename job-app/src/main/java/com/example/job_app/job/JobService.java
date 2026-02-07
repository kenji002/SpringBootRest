package com.example.job_app.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();

    void createJob(Job job);

    Job getJobByID(Long id);

    void deleteJob(Long id);
}

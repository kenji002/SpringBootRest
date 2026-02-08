package com.example.job_app.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();

    boolean createJob(Job job);

    Job getJobByID(Long id);

    boolean deleteJob(Long id);

    boolean updateJob(Long id, Job job);
}

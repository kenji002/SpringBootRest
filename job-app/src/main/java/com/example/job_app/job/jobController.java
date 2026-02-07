package com.example.job_app.job;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> findAll() {
        return jobService.findAll();
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return "Job added successfully";
    }

    
}

/**
 * - GET /jobs: 全ての求人情報を取得する
 * - GET /jobs/{id}: 指定されたIDの求人情報を取得する
 * - POST /jobs: 新しい求人情報を追加する
 * - PUT /jobs/{id}: 指定されたIDの求人情報を更新する
 * - DELETE /jobs/{id}: 指定されたIDの求人情報を削除する
 * - GET /jobs/{id}/company: 指定されたIDの求人情報の会社情報を取得する
 * 
 * Example API URLs:
 * - GET {base_url}/jobs
 * - GET {base_url}/jobs/1
 * - POST {base_url}/jobs
 * - PUT {base_url}/jobs/1
 * - DELETE {base_url}/jobs/1
 * - GET {base_url}/jobs/1/company
 */
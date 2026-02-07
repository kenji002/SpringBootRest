package com.example.job_app.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {
    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    /* GET /jobs: 全ての求人情報を取得する */
    @GetMapping("/jobs")
    public List<Job> findAll() {
        return jobService.findAll();
    }

    /* POST /jobs: 新しい求人情報を追加する */
    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return "Jobが正常に追加されました";
    }

    /* GET /jobs/{id}: 指定されたIDの求人情報を取得する */
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobByID(@PathVariable Long id) {
        System.out.println("GET /jobs/" + id + " check.");
        Job job = jobService.getJobByID(id);
        if (job == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(job);
    }
}

/**
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
package com.example.job_app.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    /* GET /jobs: 全ての求人情報を取得する */
    @GetMapping
    public ResponseEntity<List<Job>> findAll() {
        return ResponseEntity.ok(jobService.findAll());
    }

    /* POST /jobs: 新しい求人情報を追加する */
    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        if (jobService.createJob(job)) {
            return ResponseEntity.ok("Job created successfully");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    /** GET /jobs/{id}: 指定されたIDの求人情報を取得する */
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobByID(@PathVariable Long id) {
        Job job = jobService.getJobByID(id);
        if (job == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(job);
    }

    /** DELETE /jobs/{id}: 指定されたIDの求人情報を削除する */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        if (jobService.deleteJob(id)) {
            return ResponseEntity.ok("Job deleted successfully");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    /** PUT /jobs/{id}: 指定されたIDの求人情報を更新する */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job job) {
        if (jobService.updateJob(id, job)) {
            return ResponseEntity.ok("Job updated successfully");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    /* GET /jobs/{id}/company: 指定されたIDの求人情報の会社情報を取得する */
    // @GetMapping("/{id}/company")
    // public ResponseEntity<Company> getCompanyByJobID(@PathVariable Long id) {
    // Job job = jobService.getJobByID(id);
    // if (job == null) {
    // return ResponseEntity.notFound().build();
    // }
    // return ResponseEntity.ok(job.getCompany());
    // }

}

/**
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
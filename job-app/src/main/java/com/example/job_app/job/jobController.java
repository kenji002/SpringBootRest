package com.example.job_app.job;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class jobController {

    private List<job> jobs = new ArrayList<>();

    @GetMapping("/jobs")
    public List<job> findAll() {
        return jobs;
    }
}
package com.example.job_app.job;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.example.job_app.reviews.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private Long id;
    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Review> reviews;
}

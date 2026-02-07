package com.example.job_app.job;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private Long id;
    private String name;
    private String location;
    private String website;
    private String logo;
}

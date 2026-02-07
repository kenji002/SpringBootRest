package com.example.job_app.company;

import java.util.List;

public interface CompanyService {

    List<Company> findAllCompanies();

    void createCompany(Company company);

    Company getCompanyByID(Long id);

    void deleteCompany(Long id);

    void updateCompany(Long id, Company company);

}

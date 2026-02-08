package com.example.job_app.company;

import java.util.List;

public interface CompanyService {

    List<Company> findAllCompanies();

    boolean createCompany(Company company);

    Company getCompanyByID(Long id);

    boolean deleteCompany(Long id);

    boolean updateCompany(Long id, Company company);

    boolean existsById(Long id);

}

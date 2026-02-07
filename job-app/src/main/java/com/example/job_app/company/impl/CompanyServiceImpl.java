package com.example.job_app.company.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.job_app.company.Company;
import com.example.job_app.company.CompanyRepository;
import com.example.job_app.company.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

    CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company getCompanyByID(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCompany(Long id) {
        if (!companyRepository.existsById(id)) {
            throw new RuntimeException("Company not found");
        }
        companyRepository.deleteById(id);
    }

    @Override
    public void updateCompany(Long id, Company company) {
        if (!companyRepository.existsById(id)) {
            throw new RuntimeException("Company not found");
        }
        Company existingCompany = companyRepository.findById(id).get();
        existingCompany.setName(company.getName());
        existingCompany.setDescription(company.getDescription());
        companyRepository.save(existingCompany);
    }

}

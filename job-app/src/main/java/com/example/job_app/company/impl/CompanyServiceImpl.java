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
    public boolean createCompany(Company company) {
        if (company.getId() != null && companyRepository.existsById(company.getId())) {
            return false;
        }
        companyRepository.save(company);
        return true;
    }

    @Override
    public Company getCompanyByID(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompany(Long id) {
        if (!companyRepository.existsById(id)) {
            return false;
        }
        companyRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateCompany(Long id, Company company) {
        if (!companyRepository.existsById(id)) {
            return false;
        }
        Company existingCompany = companyRepository.findById(id).get();
        existingCompany.setName(company.getName());
        existingCompany.setDescription(company.getDescription());
        companyRepository.save(existingCompany);
        return true;
    }

    @Override
    public boolean existsById(Long companyId) {
        return companyRepository.existsById(companyId);
    }

}

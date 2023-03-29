package com.hunt.otziv.services;

import com.hunt.otziv.dto.CompanyDto;
import com.hunt.otziv.model.Category;
import com.hunt.otziv.model.Company;

import java.util.List;

public interface CompanyService {
    List<CompanyDto> findAll();

    void saveCompany( CompanyDto companyDto);

    CompanyDto findById(Long id);

    void editCompany(CompanyDto companyDto);
}

package com.hunt.otziv.repository;

import com.hunt.otziv.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}

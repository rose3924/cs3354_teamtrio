package com.utd.cs.cprm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.utd.cs.cprm.model.InsuranceCompany;

public interface InsuranceCompanyRepository extends JpaRepository<InsuranceCompany, Long> {

	List<InsuranceCompany> findAll();
    Optional<InsuranceCompany> findById(Long id);
}

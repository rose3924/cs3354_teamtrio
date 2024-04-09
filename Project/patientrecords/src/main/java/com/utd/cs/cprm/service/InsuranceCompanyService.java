package com.utd.cs.cprm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utd.cs.cprm.model.InsuranceCompany;
import com.utd.cs.cprm.repository.InsuranceCompanyRepository;

@Service
public class InsuranceCompanyService {

	@Autowired
	private InsuranceCompanyRepository repo;
	
	public List<InsuranceCompany> findAll(){
		List<InsuranceCompany> list = repo.findAll();
        return list;
	}
    public Optional<InsuranceCompany> findById(Long id){
    	Optional<InsuranceCompany> org = repo.findById(id);
        return org;
    }
}

package com.utd.cs.cprm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utd.cs.cprm.model.Organization;
import com.utd.cs.cprm.repository.OrganizationRespository;

@Service
public class OrganizationService {

	@Autowired
	private OrganizationRespository orgRepo;
	public List<Organization> findAll() {
		List<Organization> list = orgRepo.findAll();
		return list;
	}
	public Optional<Organization> findById(Long id) {
        Optional<Organization> org = orgRepo.findById(id);
        return org;
    }
    public Organization findByOrganizationKey(String key) {
        Organization org = orgRepo.findByOrganizationKey(key);
        return org;
    }
}

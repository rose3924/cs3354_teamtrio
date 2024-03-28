package com.utd.cs.cprm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utd.cs.cprm.model.Organization;

public interface OrganizationRespository extends JpaRepository<Organization, Long> {

	List<Organization> findAll();
	Organization findByOrganizationKey(String key);
	Optional<Organization> findById(Long id);

}

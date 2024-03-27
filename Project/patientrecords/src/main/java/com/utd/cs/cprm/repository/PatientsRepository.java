package com.utd.cs.cprm.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utd.cs.cprm.model.Patient;

@Repository

public interface PatientsRepository extends JpaRepository <Patient, String> {
	Page <Patient> findByPatientsId(String patientsId, Pageable paging);
	Page <Patient> findAll(Pageable paging);
}

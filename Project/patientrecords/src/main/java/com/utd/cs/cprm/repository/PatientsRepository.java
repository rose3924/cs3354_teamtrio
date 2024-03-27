package com.utd.cs.cprm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utd.cs.cprm.model.Patient;

@Repository

public interface PatientsRepository extends JpaRepository <Patient, String> {
	List <Patient> findAll();
}

package com.utd.cs.cprm.repository;


import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utd.cs.cprm.model.Patient;

@Repository

public interface PatientsRepository extends JpaRepository <Patient, String> {
	Page <Patient> findByPatientsId(String patientsId, Pageable paging);
	Page <Patient> findByPatientsIdOrLastName(String patientsId, String lastName,Pageable paging);
	Page <Patient> findAll(Pageable paging);
	Patient findByPatientsId(String patientsId);
	Patient findByLastName(String lastName);
	Patient findByHomePhone(String homePhone);
    Patient findBySocialSecurityNumber(String socialSecurityNumber);
    List<Patient> findByLastNameAndDateOfBirth(String lastName, Date dateOfBirth);
    List<Patient> findByLastNameAndFirstName(String lastName, String firstName);
}

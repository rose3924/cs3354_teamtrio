package com.utd.cs.cprm.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.utd.cs.cprm.model.Patient;
import com.utd.cs.cprm.repository.PatientsRepository;

@Service

public class PatientSearchService {
	@Autowired
	private PatientsRepository patientRepo;
	
	public Page <Patient> getByPatientsId(String patientsId, Pageable paging) {
		Page<Patient> list = patientRepo.findByPatientsId(patientsId, paging);
        return list;
	}
	public Page <Patient> getByPatientsIdOrLastName(String patientsId, String lastName,Pageable paging) {
		Page<Patient> list = patientRepo.findByPatientsIdOrLastName(patientsId, lastName,paging);
        return list;
	}
	public Page <Patient> findAll (Pageable paging){
		Page <Patient> list = patientRepo.findAll(paging);
		return list;
	}
}

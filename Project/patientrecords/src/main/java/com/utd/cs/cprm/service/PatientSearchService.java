package com.utd.cs.cprm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utd.cs.cprm.model.Patient;
import com.utd.cs.cprm.repository.PatientsRepository;

@Service

public class PatientSearchService {
	@Autowired
	private PatientsRepository patientRepo;
	
	public List <Patient> findAll (){
		List <Patient> list = patientRepo.findAll();
		return list;
	}
}

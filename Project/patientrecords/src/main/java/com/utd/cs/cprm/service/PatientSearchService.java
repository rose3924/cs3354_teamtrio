package com.utd.cs.cprm.service;


import java.util.Random;

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
	public Patient getByPatientsId(String patientsId) {
        Patient p = patientRepo.findByPatientsId(patientsId);
        return p;
    }
	public Patient getBySocialSecurityNumber(String socialSecurityNumber) {
        Patient p = patientRepo.findBySocialSecurityNumber(socialSecurityNumber);
        return p;
    }
	public Patient savePatient(Patient p) {
        return patientRepo.save(p);
    }
	private String generateNewPatientId(Random rand, String initialChar, String lastChar) {
		StringBuilder newId = new StringBuilder();
		newId.append(initialChar);
		int i = rand.nextInt(1000);
		String format_i = String.format("%03d", i);
        newId.append(format_i);
        i = rand.nextInt(10000);
        format_i = String.format("%04d", i);
        newId.append("-");
        newId.append(format_i);
        i = rand.nextInt(10000);
        format_i = String.format("%04d", i);
        newId.append("-");
        newId.append(format_i);
        newId.append(lastChar);
        // ex: P123-1234-1234A
        return newId.toString();
	}
	public String generatePatientId() {
		Random rand = new Random();
		String newId = generateNewPatientId(rand, "P", "A");
		Patient p = getByPatientsId(newId);
        while(p != null) {
            newId = generateNewPatientId(rand, "P", "A");
            p = getByPatientsId(newId);
        }
		return newId;
	}
}

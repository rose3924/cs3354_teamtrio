package com.utd.cs.cprm.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.utd.cs.cprm.model.Record;
import com.utd.cs.cprm.repository.RecordRepository;

@Service
public class RecordService {

	@Autowired 
    public RecordRepository recordrepo;


    public List<Record> findAll() {
        List<Record> list = recordrepo.findAll();
        return list;
    }

    public Page<Record> findAll(Pageable paging) {
        Page<Record> list = recordrepo.findAll(paging);
        return list;
    }
    
    public Record findByPatientsIdAndVisitDate(String patientsId, Date visitDate) {
        Record r = recordrepo.findByPatientPatientsIdAndVisitDate(patientsId, visitDate);
        return r;
    }

    public Page<Record> findByPatientId(String patientId, Pageable paging) {
        Page<Record> list = recordrepo.findByPatientPatientsId(patientId, paging);
        return list;
    }
    public Page<Record> findByPatientPatientsIdOrPatientLastName(String patientsId, String lastName, Pageable paging) {
        Page<Record> list = recordrepo.findByPatientPatientsIdOrPatientLastName(patientsId, lastName, paging);
        return list;
    }
    
    public Record saveRecord (Record r) {
    	return recordrepo.save(r);
    }
}

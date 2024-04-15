package com.utd.cs.cprm.repository;


import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utd.cs.cprm.model.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long>{

	List<Record> findAll();
	Record findByPatientPatientsIdAndVisitDate(String patientsId, Date visitDate);

    Page<Record> findByPatientPatientsId(String patientsId, Pageable paging);
    Page<Record> findByPatientPatientsIdOrPatientLastName(String patientsId, String lastName, Pageable paging);
}

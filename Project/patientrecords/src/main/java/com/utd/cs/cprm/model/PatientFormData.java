package com.utd.cs.cprm.model;

import java.sql.Date;

public class PatientFormData {

    private Patient p;
    private Record r;
    private String userLogin;
    
    private String patientcomments;
    private String patientsrelativeconditions;
    
    public PatientFormData() {}

    public void setupRecord(Patient patient, Date visitDate, String description) {
        r = new Record(patient, description, visitDate);
    }
    
	public Patient getPatient() {
		return p;
	}

	public void setPatient(Patient p) {
		this.p = p;
	}

	public Record getRecord() {
		return r;
	}

	public void setRecord(Record r) {
		this.r = r;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
    
	public String getPatientComments() {
        return patientcomments;
    }
    public void setPatientComments(String x) {
        this.patientcomments = x;
    }

    public String getPatientsRelativeConditions() {
        return patientsrelativeconditions;
    }
    public void setPatientsRelativeConditions(String x) {
        this.patientsrelativeconditions = x;
    }
}

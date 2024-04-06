package com.utd.cs.cprm.model;

public class PatientFormData {

	private Long insuranceId;
    private Patient p;
    
    public PatientFormData() {}

	public Long getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(Long insuranceId) {
		this.insuranceId = insuranceId;
	}

	public Patient getPatient() {
		return p;
	}

	public void setPatient(Patient p) {
		this.p = p;
	}
    
    
}

package com.utd.cs.cprm.model;

import java.sql.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "record")
public class Record {

	@Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patients_id")
    private Patient patient;
	
	@Column(name="temperature")
    private Float temperature;
	
	@Column(name="weight")
    private Float weight;

    @Column(name="description", length = 500)
    private String description;
    
    @Column(name="symptoms", length = 250)
    private String symptoms;

    @Column(name="relatives_conditions", length = 250)
    private String relativesConditions;
    
    @Column(name="nurse_comments", length = 500)
    private String nurseComments;

    @Column(name="doctor_analysis", length = 500)
    private String doctorAnalysis;
    
    @Column(name="visit_date ")
    private Date visitDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nurse", nullable = true)
    private User nurse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor", nullable = true)
    private User doctor;
    
    public Record() {}

	public Record(Patient patient, String description, Date visitDate) {
		super();
		this.patient = patient;
		this.description = description;
		this.visitDate = visitDate;
	}

	

	public Record(Long id, Patient patient, Float temperature, Float weight, String description, String symptoms,
			String relativesConditions, String nurseComments, String doctorAnalysis, Date visitDate, User nurse,
			User doctor) {
		super();
		this.id = id;
		this.patient = patient;
		this.temperature = temperature;
		this.weight = weight;
		this.description = description;
		this.symptoms = symptoms;
		this.relativesConditions = relativesConditions;
		this.nurseComments = nurseComments;
		this.doctorAnalysis = doctorAnalysis;
		this.visitDate = visitDate;
		this.nurse = nurse;
		this.doctor = doctor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Float getTemperature() {
		return temperature;
	}

	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getNurseComments() {
		return nurseComments;
	}

	public void setNurseComments(String nurseComments) {
		this.nurseComments = nurseComments;
	}

	public String getDoctorAnalysis() {
		return doctorAnalysis;
	}

	public void setDoctorAnalysis(String doctorAnalysis) {
		this.doctorAnalysis = doctorAnalysis;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public User getNurse() {
		return nurse;
	}

	public void setNurse(User nurse) {
		this.nurse = nurse;
	}

	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	public String getRelativesConditions() {
		return relativesConditions;
	}

	public void setRelativesConditions(String relativesConditions) {
		this.relativesConditions = relativesConditions;
	}
    
    
}



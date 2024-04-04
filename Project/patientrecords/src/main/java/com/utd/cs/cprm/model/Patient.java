package com.utd.cs.cprm.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="patients")
public class Patient {
	@Id
	@Column(name="patients_id")
	private String patientsId;
	
	@Column(name="gender", length = 10, nullable = true)
    private String gender;
	
	@Column(name="firstname", length = 25)
    private String firstName;

    @Column(name="middlename", length = 25)
    private String middleName;

    @Column(name="lastname", length = 35)
    private String lastName;
    
    @Column (name="date_of_birth")
    private Date dateOfBirth;
    
    @Column(name="insurance_member_id", length = 35)
    private String insuranceMemberId;

    @Column(name="insurance_group_num", length = 12)
    private String insuranceGroupNum;

    @Column(name="insurance_verification_date", nullable = true)
    private Date insuranceVerificationDate;
    
//  current_insurance_company_id    serial references insurance_company(id),
    @Column(name="social_security_num")
    private String socialSecurityNum;

    @Column(name="home_phone")
    private String homePhone;

    @Column(name="street_address", length = 100)
    private String streetAddress;

    @Column(name="zip_code", length = 10)
    private String zipCode;

    @Column(name="state_short", length = 2)
    private String stateShort;

    public Patient() {}
    
	public Patient(String patientsId, String gender, String firstName, String middleName, String lastName,
			Date dateOfBirth, String insuranceMemberId, String insuranceGroupNum, Date insuranceVerificationDate,
			String socialSecurityNum, String homePhone, String streetAddress, String zipCode, String stateShort) {
		super();
		this.patientsId = patientsId;
		this.gender = gender;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.insuranceMemberId = insuranceMemberId;
		this.insuranceGroupNum = insuranceGroupNum;
		this.insuranceVerificationDate = insuranceVerificationDate;
		this.socialSecurityNum = socialSecurityNum;
		this.homePhone = homePhone;
		this.streetAddress = streetAddress;
		this.zipCode = zipCode;
		this.stateShort = stateShort;
	}

	public String getPatientsId() {
		return patientsId;
	}

	public void setPatientsId(String patientsId) {
		this.patientsId = patientsId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getInsuranceMemberId() {
		return insuranceMemberId;
	}

	public void setInsuranceMemberId(String insuranceMemberId) {
		this.insuranceMemberId = insuranceMemberId;
	}

	public String getInsuranceGroupNum() {
		return insuranceGroupNum;
	}

	public void setInsuranceGroupNum(String insuranceGroupNum) {
		this.insuranceGroupNum = insuranceGroupNum;
	}

	public Date getInsuranceVerificationDate() {
		return insuranceVerificationDate;
	}

	public void setInsuranceVerificationDate(Date insuranceVerificationDate) {
		this.insuranceVerificationDate = insuranceVerificationDate;
	}

	public String getSocialSecurityNum() {
		return socialSecurityNum;
	}

	public void setSocialSecurityNum(String socialSecurityNum) {
		this.socialSecurityNum = socialSecurityNum;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStateShort() {
		return stateShort;
	}

	public void setStateShort(String stateShort) {
		this.stateShort = stateShort;
	}
    
    
}

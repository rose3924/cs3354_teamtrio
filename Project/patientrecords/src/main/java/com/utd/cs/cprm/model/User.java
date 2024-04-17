package com.utd.cs.cprm.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
    @Column(name="login")
    private String login;

    @Column(name="firstname", length = 25)
    private String firstName;
    
    @Column(name="middlename", length = 25)
    private String middleName;

    @Column(name="lastname", length = 35)
    private String lastName;

    @Column(name="user_role", length = 12)
    private String userRole;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @Column(length = 1)
    private String enabled;
    
    @Column(name="password", length = 25)
    private String password;
    
    @Column(name="mobile_number", length = 18)
    private String mobileNumber;
    
    @Column(name="date_of_birth ")
    private Date dateOfBirth;

	public User() {
		super();
	}
	




	public User(String login, String firstName, String middleName, String lastName, String userRole,
			Organization organization, String enabled, String password, String mobileNumber, Date dateOfBirth) {
		super();
		this.login = login;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.userRole = userRole;
		this.organization = organization;
		this.enabled = enabled;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
	}





	public Date getDateOfBirth() {
		return dateOfBirth;
	}





	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}





	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}



	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
    
    
}

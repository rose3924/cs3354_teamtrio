package com.utd.cs.cprm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name="login")
    private String login;
	
	@Column(name="password", length = 25)
    private String password;

    @Column(name="firstname", length = 25)
    private String firstName;

    @Column(name="middlename", length = 25)
    private String middleName;

    @Column(name="lastname", length = 35)
    private String lastName;

    @Column(name="role", length = 12)
    private String role;  // doctor/nurse/staff

    @Column(name="username", unique = true, nullable = false)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="email", unique = true, nullable = false)
    private String email;

    @Column(name="department")
    private String department;

    @Column(name="mobile_number")
    private String mobileNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @Column(length = 1)
    private String enabled;

    @Column(name="personnel_type")
    private String personnelType; // Added new field for Medical Personnel Type

<<<<<<< Updated upstream
	

	public User(String login, String password, String firstName, String lastName, String userRole,
			Organization organization, String enabled) {
		super();
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userRole = userRole;
		this.organization = organization;
		this.enabled = enabled;
	}
=======
    public User() {
        super();
    }
>>>>>>> Stashed changes

    public User(String login, String firstName, String middleName, String lastName, String role, String username, String password, String email, String department, String mobileNumber, Organization organization, String enabled, String personnelType) {
        this.login = login;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.role = role;
        this.username = username;
        this.password = password;
        this.email = email;
        this.department = department;
        this.mobileNumber = mobileNumber;
        this.organization = organization;
        this.enabled = enabled;
        this.personnelType = personnelType; // Initialize new field
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

<<<<<<< Updated upstream
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
=======
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
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

    // Getters and Setters for the new field
    public String getPersonnelType() {
        return personnelType;
    }

    public void setPersonnelType(String personnelType) {
        this.personnelType = personnelType;
    }
>>>>>>> Stashed changes
}

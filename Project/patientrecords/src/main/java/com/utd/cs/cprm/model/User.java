package com.utd.cs.cprm.model;

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

    @Column(name="lastname", length = 35)
    private String lastName;

    @Column(name="user_role", length = 12)
    private String userRole;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @Column(length = 1)
    private String enabled;

	public User() {
		super();
	}

	public User(String login, String firstName, String lastName, String userRole, Organization organization,
			String enabled) {
		super();
		this.login = login;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userRole = userRole;
		this.organization = organization;
		this.enabled = enabled;
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
    
    
}

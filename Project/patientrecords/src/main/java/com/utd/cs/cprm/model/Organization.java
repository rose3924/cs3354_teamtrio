package com.utd.cs.cprm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "organization")
public class Organization {

	@Id 
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length=55, nullable=false)
	private String name;
	
	@Column(length = 500)
    private String description;

    @Column(length = 35)
    private String tin;
    
    @Column(name="organization_key", length = 55, nullable = false)
    private String organizationKey;

    @Column(name="biz_address", length = 100)
    private String businessAddress;

    @Column(name="city", length = 35)
    private String city;

    @Column(name="zip_code", length = 10)
    private String zipCode;

    @Column(name="state_short", length = 2)
    private String state;

    @Column(length = 1)
    private String enabled;

    @Column(length = 18)
    private String phone;
    
    public Organization() {}

	public Organization(Long id, String name, String description, String tin, String organizationKey,
			String businessAddress, String city, String zipCode, String state, String enabled, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.tin = tin;
		this.organizationKey = organizationKey;
		this.businessAddress = businessAddress;
		this.city = city;
		this.zipCode = zipCode;
		this.state = state;
		this.enabled = enabled;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTin() {
		return tin;
	}

	public void setTin(String tin) {
		this.tin = tin;
	}

	public String getOrganizationKey() {
		return organizationKey;
	}

	public void setOrganizationKey(String organizationKey) {
		this.organizationKey = organizationKey;
	}

	public String getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

    
}

package com.utd.cs.cprm.model;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "insurance_company")
public class InsuranceCompany {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="company_id", length = 18, nullable = false)
    private String companyId;
	
	@Column(length = 25)
    private String name;

    @Column(length = 1)
    private String active;
    
    public InsuranceCompany() {}

	public InsuranceCompany(Long id, String companyId, String name, String active) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.name = name;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
    
}

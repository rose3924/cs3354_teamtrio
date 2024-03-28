package com.utd.cs.cprm.model;

public class IndexFormData {
	
	private Long organizationId;
    private String usersKeyEntry;
    private String errorMessage;

    public IndexFormData() {
    }

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public String getUsersKeyEntry() {
		return usersKeyEntry;
	}

	public void setUsersKeyEntry(String usersKeyEntry) {
		this.usersKeyEntry = usersKeyEntry;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
    
    
}

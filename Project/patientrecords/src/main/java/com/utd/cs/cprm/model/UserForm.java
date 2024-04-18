package com.utd.cs.cprm.model;

public class UserForm {

	private User u;
	
	private String passverify;
	
	public UserForm() {
		u = new User();
		u.setEnabled("T");
		u.setUserRole("user");
	}

	
	public UserForm(User u, String passverify) {
		super();
		this.u = u;
		this.passverify = passverify;
	}


	public User getUser() {
		return u;
	}

	public void setUser(User u) {
		this.u = u;
	}

	public String getPassverify() {
		return passverify;
	}

	public void setPassverify(String passverify) {
		this.passverify = passverify;
	}
	
	
}

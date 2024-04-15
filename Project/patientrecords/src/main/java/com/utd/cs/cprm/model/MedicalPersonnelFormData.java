package com.utd.cs.cprm.model;

import java.sql.Date;

public class MedicalPersonnelFormData {

    private User medicalPersonnel;
    private PersonnelRecord r;
    private String userLogin;
    
    public MedicalPersonnelFormData() {}

    public void setupRecord(User user, String role) {
        r = new PersonnelRecord(user.getFirstName(), user.getLastName(),
                                role, user.getLogin(), user.getPassword(), user.getEmail());
    }
    
    public User getMedicalPersonnel() {
        return medicalPersonnel;
    }

    public void setMedicalPersonnel(User medicalPersonnel) {
        this.medicalPersonnel = medicalPersonnel;
    }

    public PersonnelRecord getRecord() {
        return r;
    }

    public void setRecord(PersonnelRecord r) {
        this.r = r;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }
}

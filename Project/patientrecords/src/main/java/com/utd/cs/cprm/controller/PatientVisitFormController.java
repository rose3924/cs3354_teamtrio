package com.utd.cs.cprm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import org.springframework.web.servlet.view.RedirectView;

import com.utd.cs.cprm.model.Patient;
import com.utd.cs.cprm.model.PatientFormData;
import com.utd.cs.cprm.model.User;
import com.utd.cs.cprm.service.PatientSearchService;
import com.utd.cs.cprm.service.RecordService;
import com.utd.cs.cprm.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

import com.utd.cs.cprm.model.Record;

@RestController
public class PatientVisitFormController {

	@Autowired 
    private PatientSearchService patientService;
	
	@Autowired 
    private UserService userService;
	
	@Autowired 
    private RecordService recService;
	
	@GetMapping("patientvisitform")
    public ModelAndView getVisitData(HttpServletRequest request,  @RequestParam(value = "keyword", required = false) String keyword) {
		ModelAndView mav = new ModelAndView("patientvisitform");
        PatientFormData formData = new PatientFormData();
        try {
        	if (keyword != null && keyword.equals("") == false) {
        		Patient p = patientService.getByPatientsId(keyword);
                formData.setPatient( p);
                
                long millis = System.currentTimeMillis(); 
                java.sql.Date date = new java.sql.Date(millis);
                Record r = recService.findByPatientsIdAndVisitDate(keyword, date);
                if (r != null) {
                	formData.setRecord(r);
                }
                else {
                	formData.setupRecord(p, date, "New Visit");
                }
        	}
        	else {
        		mav.addObject("message", "Patient Id is required.");
        	}
        	mav.addObject("formData", formData);
        	mav.addObject("userList", userService.findAll());
        } catch (Exception e) {
            mav.addObject("message", e.getMessage());
        }
        return mav;
    }
	
	@PostMapping("/registervisitrecord")
    public RedirectView verifyPatientRegistration(RedirectAttributesModelMap model, @ModelAttribute("formData") PatientFormData formData) {
		System.out.println("IN /registervisitrecord verifyPatientRegistration()");
		RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/home");
        try {
        	String pId = formData.getRecord().getPatient().getPatientsId();
            System.out.println("Record.PatientsId=" + pId);
            Patient p = patientService.getByPatientsId(pId);

            Record r = formData.getRecord();
            r.setPatient(p);
        	
        	String uDocId = formData.getRecord().getDoctor().getLogin();
        	User uDoc = userService.findByLogin(uDocId);
        	formData.getRecord().setDoctor(uDoc);
        	
        	String uNurseId = formData.getRecord().getNurse().getLogin();
        	User uNurse = userService.findByLogin(uNurseId);
        	formData.getRecord().setNurse(uNurse);
        	System.out.println("Set the User properties, about to call saveRecord() ");
        	recService.saveRecord(formData.getRecord());
        	System.out.println("Set the User properties, finished calling saveRecord() ");
        } catch (Exception e) {
            model.addFlashAttribute("warningmessage", e.getMessage());
            System.out.println(e.getMessage());
        } 
            return redirectView;
    }
}

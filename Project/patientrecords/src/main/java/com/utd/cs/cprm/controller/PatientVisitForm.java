package com.utd.cs.cprm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.utd.cs.cprm.model.PatientFormData;
import com.utd.cs.cprm.service.PatientSearchService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class PatientVisitForm {

	@Autowired 
    private PatientSearchService patientService;
	
	@GetMapping("patientvisitform")
    public ModelAndView getVisitData(HttpServletRequest request,  @RequestParam(value = "keyword", required = false) String keyword) {
		ModelAndView mav = new ModelAndView("patientvisitform");
        PatientFormData formData = new PatientFormData();
        try {
        	if (keyword != null && keyword.equals("") == false) {
        		formData.setPatient(patientService.getByPatientsId(keyword));
        	}
        	else {
        		mav.addObject("message", "Patient Id is required.");
        	}
        	mav.addObject("formData", formData);
        } catch (Exception e) {
            mav.addObject("message", e.getMessage());
        }
        return mav;
    }
}

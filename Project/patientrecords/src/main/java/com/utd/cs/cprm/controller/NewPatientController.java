package com.utd.cs.cprm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.utd.cs.cprm.model.PatientFormData;

import jakarta.servlet.http.HttpServletRequest;

@RestController
 class NewPatientController {

	@GetMapping("newpatient")
	public ModelAndView getFormData(HttpServletRequest request, @RequestParam(value = "patientsid", required = false) String patientsid) {
		ModelAndView mav = new ModelAndView("newpatient");
		PatientFormData formData = new PatientFormData();
		try {
			mav.addObject("formData", formData);
			
		} catch (Exception e) {
            mav.addObject("message", e.getMessage());
        }
        return mav;
	}
}

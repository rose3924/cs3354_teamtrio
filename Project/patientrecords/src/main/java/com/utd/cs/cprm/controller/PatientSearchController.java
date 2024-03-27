package com.utd.cs.cprm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.utd.cs.cprm.service.PatientSearchService;

@RestController
public class PatientSearchController {
	
	@Autowired
	private PatientSearchService service;
	
	@GetMapping("patientsearch")
	public ModelAndView getByPatientID() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("patientsearch");
		mav.addObject("patients", service.findAll());
		return mav;
	}
}

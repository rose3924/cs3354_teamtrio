package com.utd.cs.cprm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.utd.cs.cprm.model.Patient;
import com.utd.cs.cprm.service.PatientSearchService;

@RestController
public class PatientSearchController {

	@Autowired
	private PatientSearchService service;

	@GetMapping("patientsearch")
	public ModelAndView getByPatientID(@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "btnClear", required = false) String btnClear, 
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "3") int size) {
		ModelAndView mav = new ModelAndView("patientsearch");
		Pageable paging = PageRequest.of(page - 1, size);
		Page<Patient> pagePatients;
		try {
			if ((btnClear != null) && btnClear.equals("") == false) {
				pagePatients = service.findAll(paging);
			} 
			else if ((keyword != null) && keyword.equals("") == false) {
				pagePatients = service.getByPatientsIdOrLastName(keyword, keyword, paging);
				mav.addObject("keyword", keyword);
			} 
			else {
				pagePatients = service.findAll(paging);
			}
			// ModelAndView::addObject; Model::addAttribute
			mav.addObject("patients", pagePatients.getContent());
			mav.addObject("currentPage", pagePatients.getNumber() + 1);
			mav.addObject("totalItems", pagePatients.getTotalElements());
			mav.addObject("totalPages", pagePatients.getTotalPages());
			mav.addObject("pageSize", size);
		} catch (Exception e) {
			mav.addObject("message", e.getMessage());
		}
		return mav;
	}
}

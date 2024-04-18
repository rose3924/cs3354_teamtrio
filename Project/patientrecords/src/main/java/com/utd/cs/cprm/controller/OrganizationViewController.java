package com.utd.cs.cprm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.utd.cs.cprm.model.Organization;
import com.utd.cs.cprm.service.OrganizationService;

@RestController
public class OrganizationViewController {
	
	@Autowired
	private OrganizationService service;
	
	@GetMapping("organizationview")
	public ModelAndView getByOrgID() {
		ModelAndView mav = new ModelAndView("organizationview");
		List<Organization> Organizations;
		try {
			
			Organizations = service.findAll();
			
			// ModelAndView::addObject; Model::addAttribute
			mav.addObject("organization", Organizations.get(0));
		} catch (Exception e) {
			mav.addObject("message", e.getMessage());
		}
		return mav;
	}
}
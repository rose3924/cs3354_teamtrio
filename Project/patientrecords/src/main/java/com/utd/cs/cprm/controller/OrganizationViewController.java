package com.utd.cs.cprm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.utd.cs.cprm.model.Organization;
import com.utd.cs.cprm.model.User;
import com.utd.cs.cprm.service.OrganizationService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class OrganizationViewController {
	
	@Autowired
	private OrganizationService service;
	
	@GetMapping("organizationview")
	public ModelAndView getByOrgID(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("organizationview");
		Object uObj = request.getSession().getAttribute("user");
		User u = null;
        if(uObj instanceof User ) {
            u = (User)uObj;
            System.out.println("IN /home User Org = " + u.getOrganization().getName());
        }
		List<Organization> Organizations;
		try {
			
			Organizations = service.findAll();
			
			// ModelAndView::addObject; Model::addAttribute
			if (u == null) {
				mav.addObject("organization", Organizations.get(0));
			}
			else
				mav.addObject("organization", u.getOrganization());
		} catch (Exception e) {
			mav.addObject("message", e.getMessage());
		}
		return mav;
	}
}
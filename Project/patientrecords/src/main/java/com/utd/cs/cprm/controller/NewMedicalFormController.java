package com.utd.cs.cprm.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import com.utd.cs.cprm.model.Organization;
import com.utd.cs.cprm.model.User;
import com.utd.cs.cprm.model.UserForm;
import com.utd.cs.cprm.service.OrganizationService;
import com.utd.cs.cprm.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class NewMedicalFormController {

	@Autowired
	private UserService userService;

	@Autowired
	private OrganizationService orgService;

	@GetMapping("newmedicalform")
	public ModelAndView getFormData(HttpServletRequest request,
			@RequestParam(value = "login", required = false) String login) {
		ModelAndView mav = new ModelAndView("newmedicalform");
		UserForm formData = new UserForm();
		try {
			/*if (login != null && login.equals("") == false) {
				User u = userService.findByLogin(login);
				if (u != null) {
					formData.setUser(u);
				}
			}*/

			mav.addObject("formData", formData);
			mav.addObject("organizations", orgService.findAll());

			Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
			if (flashMap != null && flashMap.containsKey("warningmessage")) {
				mav.addObject("warningmessage", flashMap.get("warningmessage"));
			}
		} catch (Exception e) {
			mav.addObject("message", e.getMessage());
		}
		return mav;
	}

	@PostMapping("/registerMedicalPersonnel")
	public RedirectView verifyPatientRegistration(RedirectAttributesModelMap model,
			@ModelAttribute("formData") UserForm formData) {
		RedirectView redirectView = new RedirectView();
		redirectView.setContextRelative(true);
		redirectView.setUrl("/home");
		
		System.out.println("IN /register POST method " );
		try {
			boolean validData = true;
				String ss = formData.getUser().getLogin();
				
				System.out.println("IN /register POST method start " + ss );
				if (ss.equals("")) {
					model.addFlashAttribute("warningmessage", "Login should not be emtpy");
					validData = false;
					redirectView.setUrl("/newmedicalform");
				}
				String fName = formData.getUser().getFirstName();
				if (fName.equals("")) {
					model.addFlashAttribute("warningmessage", "First name should not be emtpy");
					validData = false;
					redirectView.setUrl("/newmedicalform");
				}
				String lName = formData.getUser().getLastName();
				if (lName.equals("")) {
					model.addFlashAttribute("warningmessage", "Last name should not be emtpy");
					validData = false;
					redirectView.setUrl("/newmedicalform");
				}
				String pass = formData.getUser().getPassword();
				if (pass.equals("")) {
					model.addFlashAttribute("warningmessage", "Password should not be emtpy");
					validData = false;
					redirectView.setUrl("/newmedicalform");
				}
				if (pass.equals(formData.getPassverify()) == false) {
					model.addFlashAttribute("warningmessage", "Passwords Don't Match");
					validData = false;
					redirectView.setUrl("/newmedicalform");
				}
				if (validData) {
					Long icompanyId = formData.getUser().getOrganization().getId();
					Optional<Organization> c = orgService.findById(icompanyId);
					if (c != null) {
						formData.getUser().setOrganization(c.get());
					}
					userService.saveUser(formData.getUser());
					System.out.println("IN /register POST method saved " );

				}

		} catch (Exception e) {
			model.addFlashAttribute("warningmessage", e.getMessage());
		}
		return redirectView;
	}

}

package com.utd.cs.cprm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import com.utd.cs.cprm.model.IndexFormData;
import com.utd.cs.cprm.model.Organization;
import com.utd.cs.cprm.service.OrganizationService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class IndexController {

	@Autowired
	private OrganizationService orgSer;
	
	@GetMapping("index")
	public ModelAndView getFormData(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("index");
		IndexFormData formData = new IndexFormData();
		try {
			mav.addObject("formData", formData);
			mav.addObject("organizations", orgSer.findAll());
			Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
			if (flashMap != null && flashMap.containsKey("message")) {
				mav.addObject("message", flashMap.get("message"));
			}
		}catch (Exception e) {
			mav.addObject("message", "Invalid Organization information, try again.");
		}
		return mav;
	}
	
	@PostMapping("/orgverifiy")
    public RedirectView verifyOrganizationSelection (RedirectAttributesModelMap model, 
    		@ModelAttribute("formData") IndexFormData formData) {
		Organization org = orgSer.findByOrganizationKey(formData.getUsersKeyEntry());
		RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        
        if(org != null) {
        	redirectView.setUrl("login");
        }
        else {
        	redirectView.setUrl("index");
        	model.addFlashAttribute("message", "Invalid Organization information, try again.");
        }
        return redirectView;
	}
}

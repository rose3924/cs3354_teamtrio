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

import com.utd.cs.cprm.model.InsuranceCompany;
import com.utd.cs.cprm.model.Patient;
import com.utd.cs.cprm.model.PatientFormData;
import com.utd.cs.cprm.service.InsuranceCompanyService;
import com.utd.cs.cprm.service.PatientSearchService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
 class NewPatientController {

	@Autowired 
    private InsuranceCompanyService insuranceService; 

    @Autowired
    private PatientSearchService searchService;
	
	@GetMapping("newpatient")
	public ModelAndView getFormData(HttpServletRequest request, @RequestParam(value = "patientsid", required = false) String patientsid) {
		ModelAndView mav = new ModelAndView("newpatient");
		PatientFormData formData = new PatientFormData();
		try {
			if(patientsid != null && patientsid.equals("") == false) {
				formData.setPatient( searchService.getByPatientsId(patientsid));
			}
			else {
				Patient p = new Patient();
				p.setPatientsId(searchService.generatePatientId());
				formData.setPatient(p);
			}
			mav.addObject("formData", formData);
			mav.addObject("insurancecompanies", insuranceService.findAll());
			
			Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
            if(flashMap !=null && flashMap.containsKey("warningmessage")) {
                 mav.addObject("warningmessage", flashMap.get("warningmessage"));
            }
		} catch (Exception e) {
            mav.addObject("message", e.getMessage());
        }
        return mav;
	}
	@PostMapping("/registerpatient")
    public RedirectView verifyPatientRegistration(RedirectAttributesModelMap model, @ModelAttribute("formData") PatientFormData formData) {
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/home");
        if( formData.getPatient() != null) {
            String ss = formData.getPatient().getSocialSecurityNumber();
            if(ss != null && ss.equals("") == false) {
            	Patient p = searchService.getBySocialSecurityNumber(ss);
            	Long icompanyId = formData.getPatient().getCurrentInsuranceCompany().getId();
                Optional<InsuranceCompany> c = insuranceService.findById(icompanyId);
                if( c != null) {
                    formData.getPatient().setCurrentInsuranceCompany(c.get());
                }
                if (p != null) {
                	redirectView.setUrl("/newpatient?patientsid='" + p.getPatientsId() + "'");
                    model.addFlashAttribute("warningmessage", "Patient already exists.");
                }
                else {
                	searchService.savePatient(formData.getPatient());
                }
            }
        }
        return redirectView;
	}
}

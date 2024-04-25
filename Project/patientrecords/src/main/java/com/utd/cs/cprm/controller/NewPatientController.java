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
 public class NewPatientController {

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
        try {
            boolean validData = true;
        if( formData.getPatient() != null) {
            String ss = formData.getPatient().getSocialSecurityNumber();
            if(ss.equals("")) {
                model.addFlashAttribute("warningmessage", "Social Security Number should not be emtpy");
                validData = false;
                redirectView.setUrl("/newpatient");
            }
            if(ss.length() > 12) {
                model.addFlashAttribute("warningmessage", "Social Security Number should not be emtpy");
                validData = false;
                redirectView.setUrl("/newpatient");
            }
            String fName = formData.getPatient().getFirstName();
            if(fName.equals("")) {
                model.addFlashAttribute("warningmessage", "First name should not be emtpy");
                validData = false;
                redirectView.setUrl("/newpatient");
            }
            String lName = formData.getPatient().getLastName();
            if(lName.equals("")) {
                model.addFlashAttribute("warningmessage", "Last name should not be emtpy");
                validData = false;
                redirectView.setUrl("/newpatient");
            }
            if(validData)
            {
            if(ss != null && ss.equals("") == false) {
            	Patient p = searchService.getBySocialSecurityNumber(ss);
            	Long icompanyId = formData.getPatient().getCurrentInsuranceCompany().getId();
                Optional<InsuranceCompany> c = insuranceService.findById(icompanyId);
                if( c != null) {
                    formData.getPatient().setCurrentInsuranceCompany(c.get());
                }
                
                searchService.savePatient(formData.getPatient());
                
            }
            }
        }
        } catch (Exception e) {
            model.addFlashAttribute("warningmessage", e.getMessage());
        }
        return redirectView;
	}
}

package com.utd.cs.cprm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import org.springframework.web.servlet.view.RedirectView;

import com.utd.cs.cprm.model.User;
import com.utd.cs.cprm.service.MedicalPersonnelService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class NewMedicalFormController {

    @Autowired
    private MedicalPersonnelService medicalPersonnelService;

    @GetMapping("newmedicalform")
    public ModelAndView getFormData(HttpServletRequest request, @RequestParam(value = "medicalPersonnelId", required = false) String medicalPersonnelId) {
        ModelAndView mav = new ModelAndView("newmedicalform");
        User medicalPersonnel = new User();
        try {
            if(medicalPersonnelId != null && !medicalPersonnelId.isEmpty()) {
                medicalPersonnel = medicalPersonnelService.findById(medicalPersonnelId);
            } else {
                medicalPersonnelId = medicalPersonnelService.generateId();
                medicalPersonnel.setLogin(medicalPersonnelId);
            }
            mav.addObject("medicalPersonnel", medicalPersonnel);
        } catch (Exception e) {
            mav.addObject("message", e.getMessage());
        }
        return mav;
    }

    @PostMapping("/registerMedicalPersonnel")
    public RedirectView verifyMedicalPersonnelRegistration(
        RedirectAttributesModelMap model,
        @ModelAttribute("medicalPersonnel") User medicalPersonnel) {

        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/home");

        try {
            // Validate email
            if(!isValidEmail(medicalPersonnel.getEmail())) {
                model.addFlashAttribute("errorMessage", "Invalid email format.");
                return redirectView;
            }

            // Save or update medical personnel
            medicalPersonnelService.saveUser(medicalPersonnel);

        } catch (Exception e) {
            model.addFlashAttribute("errorMessage", "Error registering Medical Personnel: " + e.getMessage());
        }
        return redirectView;
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }
}

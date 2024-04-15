package com.utd.cs.cprm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PatientVisitReviewController {

	@GetMapping("patientvisitreview")
    public ModelAndView getPatientVisitReviewPage() {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("patientvisitreview");
        return mav;
    }
}

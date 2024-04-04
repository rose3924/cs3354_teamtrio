package com.utd.cs.cprm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AboutController {

	@GetMapping("about")
	public ModelAndView getAboutPage() {
		ModelAndView mav = new ModelAndView();
        mav.setViewName("about");
        return mav;
	}
}

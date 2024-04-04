package com.utd.cs.cprm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TeamController {

	@GetMapping("team")
	public ModelAndView getTeamPage() {
		ModelAndView mav = new ModelAndView();
        mav.setViewName("team");
        return mav;
	}
}

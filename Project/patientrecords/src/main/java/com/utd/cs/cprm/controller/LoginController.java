package com.utd.cs.cprm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import org.springframework.web.servlet.view.RedirectView;

import com.utd.cs.cprm.model.User;
import com.utd.cs.cprm.service.UserService;

@RestController
public class LoginController {

	@Autowired 
    private UserService uService;


    @GetMapping("login")
    public ModelAndView getLoginPage() {

        ModelAndView mav = new ModelAndView();
        User u = new User();
        mav.setViewName("login");
        mav.addObject("user", u);

        return mav;
    }

    @PostMapping("/verifyuserlogin")
    public RedirectView verifyLogin(RedirectAttributesModelMap model, @ModelAttribute("user") User user) {
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/home");

        try {
            String uLogin = user.getLogin();
            String upwd = user.getPassword();

            System.out.println("User.getLogin=" + uLogin);
            System.out.println("User.getPassword=" + upwd);

            User verificationUser = uService.findByLogin(uLogin);
            if(verificationUser.getPassword().equals(upwd) == false) {
            	redirectView.setUrl("/login");
                model.addFlashAttribute("warningmessage", "Invalid credentials.");
            }

        } catch (Exception e) {
            model.addFlashAttribute("warningmessage", e.getMessage());
            System.out.println(e.getMessage());
        } 


        return redirectView;
    }
}

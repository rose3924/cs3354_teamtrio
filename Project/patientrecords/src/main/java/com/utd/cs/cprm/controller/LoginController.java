package com.utd.cs.cprm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import org.springframework.web.servlet.view.RedirectView;

import com.utd.cs.cprm.model.User;
import com.utd.cs.cprm.model.Organization;
import com.utd.cs.cprm.service.OrganizationService;
import com.utd.cs.cprm.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

	@Autowired 
    private UserService uService;

	@Autowired
    private OrganizationService orgService;

    @GetMapping("login")
    public ModelAndView getLoginPage() {

        ModelAndView mav = new ModelAndView();
        User u = new User();
        mav.setViewName("login");
        mav.addObject("user", u);

        return mav;
    }

    @PostMapping("/verifyuserlogin")
    public RedirectView verifyLogin(HttpServletRequest request,RedirectAttributesModelMap model, @ModelAttribute("user") User user) {
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/home");

        try {
            String uLogin = user.getLogin();
            String upwd = user.getPassword();

            System.out.println("User.getLogin=" + uLogin);
            System.out.println("User.getPassword=" + upwd);

            User verificationUser = uService.findByLogin(uLogin);
            System.out.println("User.getLogin=" + verificationUser.getLogin());
            if(verificationUser.getPassword().equals(upwd) == false) {
            	redirectView.setUrl("/login");
                model.addFlashAttribute("warningmessage", "Invalid credentials.");
            } else {
                Long orgId = verificationUser.getOrganization().getId();
                Optional<Organization> c = orgService.findById(orgId);
                if (c != null) {
                    verificationUser.setOrganization(c.get());
                }
                request.getSession().setAttribute("user", verificationUser);
            }

        } catch (Exception e) {
        	redirectView.setUrl("/login");
            model.addFlashAttribute("warningmessage", "Invalid User Information");
            System.out.println(e.getMessage());
        } 


        return redirectView;
    }
}

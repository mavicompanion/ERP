package com.ERP.v1.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
    
    @RequestMapping(method = RequestMethod.GET, value = "/admin/dashboard")
    public ModelAndView adminDashboard(@AuthenticationPrincipal UserDetails userDetails)
    {
        ModelAndView modelAndView = new ModelAndView("adminDashboard");
        String userName = userDetails.getUsername();
        modelAndView.addObject("userName", userName);
        
        return modelAndView;
    }

}

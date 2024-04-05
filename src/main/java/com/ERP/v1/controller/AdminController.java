package com.ERP.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
    
    @RequestMapping(method = RequestMethod.GET, value = "/admin/dashboard")
    public String adminDashboard()
    {
        return "adminDashboard";
    }

}

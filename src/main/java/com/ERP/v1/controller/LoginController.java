package com.ERP.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ERP.v1.service.EmployeeService;
import com.ERP.v1.service.EnterpriseService;

@Controller
public class LoginController {
    
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EnterpriseService enterpriseService;

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public ModelAndView login()
    {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("domains", enterpriseService.getAllDomains());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/registration")
    public String registration()
    {
        return "registration";
    }

}
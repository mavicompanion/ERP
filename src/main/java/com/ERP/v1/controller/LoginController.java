package com.ERP.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ERP.v1.dto.EnterpriseRegistrationDto;
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
        List<String> domains = enterpriseService.getAllDomains();
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("domains", domains);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/registration")
    public ModelAndView registration()
    {
        ModelAndView modelAndView = new ModelAndView("registration");
        return modelAndView;
    }

}
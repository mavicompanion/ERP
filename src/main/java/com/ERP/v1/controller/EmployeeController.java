package com.ERP.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
    
    @RequestMapping(method = RequestMethod.GET, value = "/employee/dashboard")
    public String employeeDashboard()
    {
        return "employeeDashboard";
    }

}

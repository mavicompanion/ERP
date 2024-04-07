package com.ERP.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ERP.v1.dto.EmployeeDto;
import com.ERP.v1.model.Enterprise;
import com.ERP.v1.service.EmployeeService;
import com.ERP.v1.service.EnterpriseService;
import com.ERP.v1.service.ModuleService;

@Controller
public class DashboardController {
    
    @Autowired
    EnterpriseService enterpriseService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ModuleService moduleService;

    
    @RequestMapping(method = RequestMethod.GET, value = "/dashboard")
    public ModelAndView adminDashboard(@AuthenticationPrincipal UserDetails userDetails)
    {
        ModelAndView modelAndView = new ModelAndView("dashboard");
        String userName = userDetails.getUsername();
        modelAndView.addObject("userName", userName);
        modelAndView.addObject("modules", moduleService.getAllModules());
        modelAndView.addObject("userRole", userDetails.getAuthorities().iterator().next().getAuthority());
        
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/admin/employeeRegistration")
    public ModelAndView userRegistration(@AuthenticationPrincipal UserDetails userDetails, EmployeeDto employeeDto)
    {
        ModelAndView modelAndView = new ModelAndView("employeeRegistration");
        String userName = userDetails.getUsername();
        modelAndView.addObject("userEmail", userName);
        modelAndView.addObject("employees", employeeService.getAllEmployeesByDomain(employeeService.getDomainByEmail(userDetails.getUsername())));
        modelAndView.addObject("newUser", employeeDto);
        modelAndView.addObject("modules", moduleService.getAllModules());
        modelAndView.addObject("userRole", userDetails.getAuthorities().iterator().next().getAuthority());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/employeeRegistration")
    public String registerEmployee(@AuthenticationPrincipal UserDetails userDetails, @ModelAttribute EmployeeDto employeeDto)
    {
        Enterprise enterprise = enterpriseService.getEnterprise(
            employeeService.getDomainByEmail(userDetails.getUsername())
            );
        employeeService.createEmployee(employeeDto, enterprise);
        return "redirect:/admin/employeeRegistration";
    }

}

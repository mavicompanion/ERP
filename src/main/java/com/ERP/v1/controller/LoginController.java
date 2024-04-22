package com.ERP.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ERP.v1.dto.EmployeeDto;
import com.ERP.v1.dto.EnterpriseDto;
import com.ERP.v1.dto.EnterpriseRegistrationDto;
import com.ERP.v1.model.AppUser;
import com.ERP.v1.model.Employee;
import com.ERP.v1.model.Enterprise;
import com.ERP.v1.service.AppUserService;
import com.ERP.v1.service.EmployeeService;
import com.ERP.v1.service.EnterpriseService;

@Controller
public class LoginController {
    
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EnterpriseService enterpriseService;

    @Autowired
    AppUserService appUserService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String noUrl()
    {
        return "redirect:/login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public ModelAndView login()
    {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/registration")
    public ModelAndView registration()
    {
        EnterpriseRegistrationDto enterpriseRegistrationDto = new EnterpriseRegistrationDto();
        ModelAndView modelAndView = new ModelAndView("enterpriseRegistration");
        modelAndView.addObject("registrationDto", enterpriseRegistrationDto);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/registration")
    public String registrationEnd(@ModelAttribute("registrationDto") EnterpriseRegistrationDto enterpriseRegistrationDto)
    {
        EnterpriseDto enterpriseDto = new EnterpriseDto(
            enterpriseRegistrationDto.getName(), 
            enterpriseRegistrationDto.getDescription(), 
            enterpriseRegistrationDto.getAddress(), 
            enterpriseRegistrationDto.getDomain(),enterpriseRegistrationDto.getContact()
            );

        enterpriseService.createEnterprise(enterpriseDto);

        Enterprise enterprise = enterpriseService.getEnterprise(enterpriseRegistrationDto.getDomain());
        Employee employee = new Employee(enterprise, "ADMIN",enterpriseRegistrationDto.getContact());
        employeeService.createEmployee(enterprise, "ADMIN",enterpriseRegistrationDto.getContact());
        Employee employee2 = employeeService.getEmployee(employee.getName());
        appUserService.createUser(enterpriseRegistrationDto.getEmail(), enterpriseRegistrationDto.getPassword(), employee2, "ADMIN");

        return "redirect:/login";
    }

    
}
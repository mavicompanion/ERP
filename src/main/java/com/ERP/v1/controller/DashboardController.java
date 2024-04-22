package com.ERP.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ERP.v1.dto.EditEmployeeDto;
import com.ERP.v1.dto.EditUserDto;
import com.ERP.v1.dto.EmployeeDto;
import com.ERP.v1.dto.UserDto;
import com.ERP.v1.model.AppUser;
import com.ERP.v1.model.Employee;
import com.ERP.v1.model.Enterprise;
import com.ERP.v1.service.AppUserService;
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

    @Autowired
    AppUserService appUserService;


    
    @RequestMapping(method = RequestMethod.GET, value = "/dashboard")
    public ModelAndView adminDashboard(@AuthenticationPrincipal UserDetails userDetails)
    {
        ModelAndView modelAndView = new ModelAndView("dashboard");
        modelAndView.addObject("userEmail", userDetails.getUsername());
        modelAndView.addObject("modules", moduleService.getAllModules());
        modelAndView.addObject("userRole", userDetails.getAuthorities().iterator().next().toString());
        modelAndView.addObject("userName", appUserService.getAppUser(userDetails.getUsername()).getEmployee().getName());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/admin/employeeRegistration")
    public ModelAndView employeeRegistration(@AuthenticationPrincipal UserDetails userDetails, EmployeeDto employeeDto, EditEmployeeDto editEmployeeDto)
    {
        ModelAndView modelAndView = new ModelAndView("employeeRegistration");
        modelAndView.addObject("userEmail", userDetails.getUsername());
        modelAndView.addObject("modules", moduleService.getAllModules());
        modelAndView.addObject("userRole", userDetails.getAuthorities().iterator().next().toString());
        modelAndView.addObject("editEmployee", editEmployeeDto);
        modelAndView.addObject("employees", employeeService.getAllEmployees());
        modelAndView.addObject("newEmployee", employeeDto);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/admin/userRegistration")
    public ModelAndView userRegistration(@AuthenticationPrincipal UserDetails userDetails, UserDto userDto, String newUserEmpId, EditUserDto editUserDto)
    {
        ModelAndView modelAndView = new ModelAndView("userRegistration");
        modelAndView.addObject("userEmail", userDetails.getUsername());
        modelAndView.addObject("modules", moduleService.getAllModules());
        modelAndView.addObject("userRole", userDetails.getAuthorities().iterator().next().toString());
        modelAndView.addObject("users", appUserService.getAllUsers());
        modelAndView.addObject("newUserDto",userDto );
        modelAndView.addObject("newUserEmpId", newUserEmpId);
        modelAndView.addObject("editUserDto", editUserDto);
        return modelAndView;
    }
    @RequestMapping(method = RequestMethod.POST, value = "/admin/userRegistration")
    public String registerUser(@AuthenticationPrincipal UserDetails userDetails, @ModelAttribute UserDto newUserDto)
    {
        Employee employee = employeeService.getEmployeeById(Long.valueOf(newUserDto.getEmpid()));
        appUserService.createUser(newUserDto.getEmail(), newUserDto.getPassword(), employee, newUserDto.getRole());
        return "redirect:/admin/userRegistration";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/employeeRegistration")
    public String registerEmployee(@AuthenticationPrincipal UserDetails userDetails, @ModelAttribute EmployeeDto newEmployeeDto)
    {
        Enterprise enterprise = appUserService.getAppUser(userDetails.getUsername()).getEmployee().getEnterprise();
        Employee employee = new Employee(enterprise, newEmployeeDto.getName(), newEmployeeDto.getContact());
        employeeService.createEmployee(enterprise, employee.getName(), employee.getContact());
        return "redirect:/admin/employeeRegistration";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/editEmployee/{id}")
    public String editEmployee(@AuthenticationPrincipal UserDetails userDetails, @ModelAttribute("editEmployee") EditEmployeeDto employeeDto,@PathVariable String id)
    {
        Employee employee = employeeService.getEmployeeById(Long.valueOf(id));
        employee.setContact(employeeDto.getContact().equals("") ? employee.getContact() : employeeDto.getContact());
        employee.setName(employeeDto.getName().equals("") ? employee.getName() : employeeDto.getName());
        employeeService.editEmployee(employee);
        return "redirect:/admin/employeeRegistration";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/deleteEmployee/{id}")
    public String deleteEmployee(@AuthenticationPrincipal UserDetails userDetails,@PathVariable String id)
    {
        if (employeeService.getEmployeeById(
            Long.valueOf(id))
            .getEnterprise()
            .getDomain()
            .equals(
                appUserService
                .getAppUser(userDetails.getUsername())
                .getEmployee()
                .getEnterprise()
                .getDomain()
                )
            )
        {
            employeeService.deleteEmployeeById(Long.valueOf(id));
        }
        return "redirect:/admin/employeeRegistration";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/deleteUser/{id}")
    public String deleteUser(@AuthenticationPrincipal UserDetails userDetails,@PathVariable String id)
    {
        if (appUserService.getAppUserById(
            Long.valueOf(id))
            .getEmployee()
            .getEnterprise()
            .getDomain()
            .equals(
                appUserService
                .getAppUser(userDetails.getUsername())
                .getEmployee()
                .getEnterprise()
                .getDomain()
                )
            )
        {
            appUserService.deleteEmployeeById(Long.valueOf(id));
        }
        return "redirect:/admin/userRegistration";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/editUser/{id}")
    public String editUser(@AuthenticationPrincipal UserDetails userDetails, @ModelAttribute("editEmployee") EditUserDto userDto,@PathVariable String id)
    {
        AppUser user = appUserService.getAppUserById(Long.valueOf(id));
        user.setPassword(userDto.getPassword() == "" ? user.getPassword() : userDto.getPassword());
        user.setEmail(userDto.getEmail() == "" ? user.getEmail() : userDto.getEmail());
        appUserService.editUser(user);
        return "redirect:/admin/userRegistration";
    }


}

package com.ERP.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ERP.v1.model.Employee;
import com.ERP.v1.model.Enterprise;
import com.ERP.v1.repository.EmployeeRepository;

@Service
public class EmployeeService {
    
    // Creating an employee repository bean;
    @Autowired
    EmployeeRepository employeeRepository;

    // To create a new user;
    public void createEmployee(Enterprise enterprise, String name, String contact)
    {
        Employee employee = new Employee(enterprise, name,contact);
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(String name)
    {        
        List<Employee> employees = employeeRepository.findAll();

        for(Employee employee : employees)
        {
            if (employee.getName().equals(name))
            {
                return employee;
            }
        }

        return null;
    }

    public Employee getEmployeeById(Long id)
    {
        return employeeRepository.findById(id).get();
    }

    public void editEmployee(Employee employee)
    {
        employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Long id)
    {
        employeeRepository.deleteById(id);
    }

}

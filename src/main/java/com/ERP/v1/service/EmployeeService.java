package com.ERP.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ERP.v1.dto.EmployeeDto;
import com.ERP.v1.model.Employee;
import com.ERP.v1.model.Enterprise;
import com.ERP.v1.repository.EmployeeRepository;

@Service
public class EmployeeService {
    
    // Creating an employee repository bean;
    @Autowired
    EmployeeRepository employeeRepository;

    // Service method for getting all employees;
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    // Service method for getting a particular employee with email;
    public Employee getEmployee(String email)
    {
        List<Employee> employees = employeeRepository.findAll();
        for(Employee emp : employees)
        {
            if (emp.getEmail().equals(email))
            {
                return emp;
            }
        }
        return null;
    }

    // Service method for creating new employee;
    public void createEmployee(EmployeeDto employeeDto, Enterprise enterprise)
    {
        Employee employee = new Employee(
            enterprise, 
            employeeDto.getName(), 
            employeeDto.getEmail(),
            employeeDto.getPassword(),
            employeeDto.getRole()
            );
        employeeRepository.save(employee);
    }

    // Service method for deleting a particular employee with email;
    @SuppressWarnings("null")
    public void deleteEmployee(String email)
    {
        List<Employee> employees = employeeRepository.findAll();
        for(Employee emp : employees)
        {
            if (emp.getEmail().equals(email))
            {
                employeeRepository.deleteById(emp.getId());
                break;
            }
        }
    }

    // Service method for updating a particular employee with email;

}

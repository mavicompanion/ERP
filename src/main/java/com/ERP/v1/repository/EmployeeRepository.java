package com.ERP.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ERP.v1.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}

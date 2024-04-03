package com.ERP.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ERP.v1.model.Enterprise;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
    
}

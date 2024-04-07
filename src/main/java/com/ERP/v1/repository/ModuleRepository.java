package com.ERP.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ERP.v1.model.AppModule;

public interface ModuleRepository extends JpaRepository<AppModule , Long>  {
    
}

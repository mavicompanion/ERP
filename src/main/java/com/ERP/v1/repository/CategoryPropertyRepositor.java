package com.ERP.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ERP.v1.model.CatergoryProperty;

public interface CategoryPropertyRepositor extends JpaRepository<CatergoryProperty, Long> {
    
}

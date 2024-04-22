package com.ERP.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ERP.v1.model.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    
}

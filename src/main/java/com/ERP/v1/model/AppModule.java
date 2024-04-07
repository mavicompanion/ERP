package com.ERP.v1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "modules")
public class AppModule {

    @Id
    private Long id;
    @Column(name = "module_name")
    private String module_name;
    @Column(name = "module_url")
    private String module_url;
    @Column(name = "role_access")
    private String role_access;
    
    public AppModule() {
    }
    

    public AppModule(Long id, String module_name, String module_url, String role_access) {
        this.id = id;
        this.module_name = module_name;
        this.module_url = module_url;
        this.role_access = role_access;
    }


    public Long getId() {
        return id;
    }

    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public String getModule_url() {
        return module_url;
    }

    public void setModule_url(String module_url) {
        this.module_url = module_url;
    }

    public String getRole_access() {
        return role_access;
    }

    public void setRole_access(String role_access) {
        this.role_access = role_access;
    }

    
    

}

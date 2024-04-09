package com.ERP.v1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "enterprises", uniqueConstraints = @UniqueConstraint(columnNames = "domain"))
public class Enterprise {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enterprise_id")
    private Long id;
    @Column(name = "enterprise_name")
    private String name;
    @Column(name = "enterprise_description")
    private String description;
    @Column(name = "enterprise_address")
    private String address;
    @Column(name = "enterprise_domain")
    private String domain;
    @Column(name = "enterprise_contact")
    private String contact;
    
    public Enterprise() {
    }

    

    public Enterprise(String name, String description, String address, String domain, String contact) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.domain = domain;
        this.contact = contact;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }



    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    

}

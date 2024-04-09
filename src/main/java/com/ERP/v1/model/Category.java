package com.ERP.v1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;
    @Column(name = "category_name")
    private String name;
    @Column(name = "category_properties_count")
    private Long property_count;
    
    public Category() {
    }


    public Category(Enterprise enterprise, String name, Long property_count) {
        this.enterprise = enterprise;
        this.name = name;
        this.property_count = property_count;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Enterprise getEnterprise() {
        return enterprise;
    }


    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Long getProperty_count() {
        return property_count;
    }


    public void setProperty_count(Long property_count) {
        this.property_count = property_count;
    }

    

}

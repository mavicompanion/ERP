package com.ERP.v1.model;

import org.springframework.boot.context.properties.bind.ConstructorBinding;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "employees", uniqueConstraints = @UniqueConstraint(columnNames = "employee_name"))
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;
    @Column(name = "employee_name")
    private String name;
    @Column(name = "employee_contact")
    private String contact;
    
    public Employee() {
    }

    

    public Employee(Enterprise enterprise, String name, String contact_number) {
        this.enterprise = enterprise;
        this.name = name;
        this.contact = contact_number;
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



    public String getContact() {
        return contact;
    }



    public void setContact(String contact_number) {
        this.contact = contact_number;
    }

    

}

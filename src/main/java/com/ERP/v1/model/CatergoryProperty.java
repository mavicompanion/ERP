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
@Table(name = "category_properties")
public class CatergoryProperty {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_property_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Column(name = "category_property_name")
    private String name;
    @Column(name = "category_peroperty_type")
    private String type;

    public CatergoryProperty() {
    }

    public CatergoryProperty(Category category, String name, String type) {
        this.category = category;
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    

}

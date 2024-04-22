package com.ERP.v1.dto;

public class EditEmployeeDto {
 
    private Long id;
    private String name;
    private String contact;

    public EditEmployeeDto() {
    }
    
    

    public EditEmployeeDto(Long id, String name, String contact) {
        this.id = id;
        this.name = name;
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

    public String getContact() {
        return contact;
    }



    public void setContact(String contact) {
        this.contact = contact;
    }

    

}

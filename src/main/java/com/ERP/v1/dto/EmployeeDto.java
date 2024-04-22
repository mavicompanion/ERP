package com.ERP.v1.dto;


public class EmployeeDto {
    
    // Data transfer object for Employee;
    private String name;
    private String contact;
    
    public EmployeeDto() {
    }

    

    public EmployeeDto(String name, String contact) {
        this.name = name;
        this.contact = contact;
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

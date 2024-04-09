package com.ERP.v1.dto;

public class EnterpriseDto {
    // Enterprise Data transfer object;
    private String name;
    private String description;
    private String address;
    private String domain;
    private String contact;

    public EnterpriseDto() {
    }


    public EnterpriseDto(String name, String description, String address, String domain, String contact) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.domain = domain;
        this.contact = contact;
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

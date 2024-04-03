package com.ERP.v1.dto;

public class EnterpriseRegistrationDto {
    // Enterprise Registration Data transfer object;
    private String name;
    private String description;
    private String address;
    private String domain;
    private String email;
    private String password;

    public EnterpriseRegistrationDto() {
    }

    public EnterpriseRegistrationDto(String name, String description, String address, String domain, String email,
            String password) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.domain = domain;
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

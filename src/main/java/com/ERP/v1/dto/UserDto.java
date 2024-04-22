package com.ERP.v1.dto;

public class UserDto {
    private String email;
    private String password;
    private String role;
    private String empid;

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
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    
    

    public UserDto() {
    }
    public UserDto(String email, String password, String role, String empid) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.empid = empid;
    }
    public String getEmpid() {
        return empid;
    }
    public void setEmpid(String empid) {
        this.empid = empid;
    }
       
}

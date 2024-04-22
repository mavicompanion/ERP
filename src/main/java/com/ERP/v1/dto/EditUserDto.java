package com.ERP.v1.dto;

public class EditUserDto {
    private String email;
    private String password;
    public EditUserDto() {
    }
    public EditUserDto(String email, String password) {
        this.email = email;
        this.password = password;
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

package com.ERP.v1.dto;

public class CategoryPropertydto {
    private String name;
    private String type;

    public CategoryPropertydto() {
    }

    

    public CategoryPropertydto(String name, String type) {
        this.name = name;
        this.type = type;
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

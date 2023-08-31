package com.example.taskOne.dto;

public abstract class ProductDTOBase {

    private String name;

    public ProductDTOBase(String name) {
        this.name = name;
    }

    public ProductDTOBase(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

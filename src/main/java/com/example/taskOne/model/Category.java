package com.example.taskOne.model;

import com.example.taskOne.enums.SubCategory;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigserial")
    private int id;
    @JsonProperty("name")
    private String name;

    @JsonProperty("subCategory")
    @Column(name = "subcategory")
    @Enumerated(EnumType.STRING)
    private SubCategory subCategory;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;


    public Category(int id, String name, SubCategory subCategory) {
        this.id = id;
        this.name = name;
        this.subCategory = subCategory;
    }



    public String getSubCategory() {
        return subCategory.getValue();
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    public Category() {
    }


    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

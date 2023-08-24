package com.example.taskOne.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonProperty("name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonProperty("category")
    private Category category;

    public Product() {
    }

    public Product(int id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

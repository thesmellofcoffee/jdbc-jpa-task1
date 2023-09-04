package com.example.taskOne.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Collection;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Entity
public class Basket {

    @Id
    private long basketId;

    @OneToMany
    private Collection<BasketItem> basketItems = new ArrayList<>();


    public Basket() {
    }

    public Basket(Collection<BasketItem> basketItems) {
        this.basketItems.addAll(basketItems);
    }

    public long getBasketId() {
        return basketId;
    }

    public void setBasketId(long basketId) {
        this.basketId = basketId;
    }

    public Collection<BasketItem> getBasketItems() {
        return basketItems;
    }

    public void setBasketItems(Collection<BasketItem> basketItems) {
        this.basketItems = basketItems;
    }



}
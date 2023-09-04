package com.example.taskOne.dao;

import com.example.taskOne.model.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BasketItemDao extends JpaRepository<BasketItem, Long> {
    List<BasketItem> findByBasketId(@Param("basketId") long basketId);
}


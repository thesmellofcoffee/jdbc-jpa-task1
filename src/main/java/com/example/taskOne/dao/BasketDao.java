package com.example.taskOne.dao;

import com.example.taskOne.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BasketDao extends JpaRepository<Basket, Long> {
    Optional<Basket> findOneByBasketId(@Param("basketId") long basketId);
}

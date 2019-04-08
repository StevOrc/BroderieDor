package com.broderieDor.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.broderieDor.model.basket.Basket;

public interface BasketRepository extends JpaRepository<Basket, Long>{


}

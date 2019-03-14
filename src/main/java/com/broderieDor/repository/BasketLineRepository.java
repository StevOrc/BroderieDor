package com.broderieDor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.broderieDor.model.basketLine.BasketLine;

public interface BasketLineRepository extends JpaRepository<BasketLine, Long>{
	
}

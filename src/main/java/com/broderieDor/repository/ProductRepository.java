package com.broderieDor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.broderieDor.model.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	
}

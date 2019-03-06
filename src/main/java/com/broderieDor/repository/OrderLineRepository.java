package com.broderieDor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.broderieDor.model.commande.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

}

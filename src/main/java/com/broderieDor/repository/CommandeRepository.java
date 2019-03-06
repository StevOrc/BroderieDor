package com.broderieDor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.broderieDor.model.commande.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long>{

}

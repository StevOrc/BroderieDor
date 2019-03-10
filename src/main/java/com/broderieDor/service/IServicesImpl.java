package com.broderieDor.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broderieDor.model.basket.Basket;
import com.broderieDor.model.commande.Commande;
import com.broderieDor.model.commande.OrderLine;
import com.broderieDor.model.product.Product;
import com.broderieDor.model.theme.Theme;
import com.broderieDor.model.user.User;
import com.broderieDor.repository.CommandeRepository;
import com.broderieDor.repository.OrderLineRepository;
import com.broderieDor.repository.BasketRepository;
import com.broderieDor.repository.ProductRepository;
import com.broderieDor.repository.ThemeRepository;
import com.broderieDor.repository.UserRepository;


@Service
@Transactional
public class IServicesImpl implements IServices{

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	ThemeRepository themeRepo;
	
	@Autowired
	BasketRepository basketRepo;
	
	@Autowired
	CommandeRepository commandeRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	OrderLineRepository ligneCommandeRepo;

	
	@Override
	public List<Product> allProducts() {
		
		return productRepo.findAll();
	}

	@Override
	public List<Product> productByName(String name) {
		
		return null;
	}

	@Override
	public List<Basket> allPanniers() {
		
		return basketRepo.findAll();
	}

	@Override
	public List<Theme> allThemes() {
		
		return themeRepo.findAll();
	}

	@Override
	public List<Commande> allCommandes() {
		
		return commandeRepo.findAll();
	}

	@Override
	public List<User> allClients() {
	
		return userRepo.findAll();
	}

	@Override
	public List<OrderLine> allLigneCommandes() {
		
		return ligneCommandeRepo.findAll();
	}

	@Override
	public long countProduct() {
		
		return productRepo.count();
	}

	@Override
	public long themeSize() {
		
		return this.themeRepo.count();
	}


}

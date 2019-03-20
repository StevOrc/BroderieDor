package com.broderieDor.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broderieDor.model.basket.Basket;
import com.broderieDor.model.product.Product;
import com.broderieDor.model.theme.Theme;
import com.broderieDor.model.user.User;
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
	UserRepository userRepo;

	
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
	public List<User> allClients() {
	
		return userRepo.findAll();
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

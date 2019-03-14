package com.broderieDor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broderieDor.converter.BasketConverter;
import com.broderieDor.dto.BasketDto;
import com.broderieDor.model.basket.Basket;
import com.broderieDor.model.product.Product;
import com.broderieDor.model.theme.Theme;
import com.broderieDor.repository.BasketRepository;
import com.broderieDor.repository.ProductRepository;
import com.broderieDor.repository.ThemeRepository;

@Service
public class AdminServiceImpl implements IAdminService{
	
	@Autowired
	BasketConverter basketConverter;
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	ThemeRepository themeRepo;
	
	@Autowired
	BasketRepository basketRepo;

	//PRODUCT MANAGEMENT
	@Override
	public Product addProduct(Product product) {
		
		return this.productRepo.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		
		return this.productRepo.save(product);
	}

	@Override
	public void removeProduct(long id) {
		this.productRepo.deleteById(id);
	}
	
	@Override
	public Product findProductById(long id) {
	
		return this.productRepo.findById(id).get();
	}

	//Theme Management
	@Override
	public Theme createTheme(Theme theme) {
	
		return this.themeRepo.save(theme);
	}

	@Override
	public Theme updateTheme(Theme theme) {
		
		return this.themeRepo.save(theme);
	}

	@Override
	public void deleteTheme(long id) {
		this.themeRepo.deleteById(id);
	}
	
	@Override
	public Theme findThemeById(long id) {
		
		return this.themeRepo.findById(id).get();
	}
	
	@Override
	public Theme findThemeByName(String name) {
		
		return this.themeRepo.findByName(name);
	}

	//BASKET MANAGEMENT
	@Override
	public List<Basket> readAllBasket() {
		
		return this.basketRepo.findAll();
	}

	@Override
	public Basket createBasket(Basket basket) {
		
		return this.basketRepo.save(basket);
	}

	@Override
	public Basket updateBasket(Basket basket) {
		
		return this.basketRepo.save(basket);
	}

	@Override
	public void deletBasket(long id) {
		this.basketRepo.deleteById(id);
	}
	
	@Override
	public Basket findBasketById(long id) {
		
		return this.basketRepo.findById(id).get();
	}
	
	//ConvertetDto
	public Basket convertBasketDtoToBasket(BasketDto basketDto) {
		
		 return this.basketConverter.convert(basketDto);
	}
}

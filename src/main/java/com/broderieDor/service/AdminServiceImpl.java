package com.broderieDor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broderieDor.model.product.Product;
import com.broderieDor.model.theme.Theme;
import com.broderieDor.repository.ProductRepository;
import com.broderieDor.repository.ThemeRepository;

@Service
public class AdminServiceImpl implements IAdminService{
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	ThemeRepository themeRepo;

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
	
}

package com.broderieDor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broderieDor.model.product.Product;
import com.broderieDor.repository.ProductRepository;

@Service
public class AdminServiceImpl implements IAdminService{
	
	@Autowired
	ProductRepository productRepo;

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

}

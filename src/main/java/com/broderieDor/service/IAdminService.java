package com.broderieDor.service;

import com.broderieDor.model.product.Product;

public interface IAdminService {
	
	public Product addProduct(Product product);
	public Product updateProduct(Product product);
	public void removeProduct(long id);
}

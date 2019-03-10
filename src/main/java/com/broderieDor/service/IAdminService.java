package com.broderieDor.service;

import com.broderieDor.model.product.Product;
import com.broderieDor.model.theme.Theme;

public interface IAdminService {
	
	// Product management
	public Product addProduct(Product product);
	public Product updateProduct(Product product);
	public void removeProduct(long id);
	
	//Theme management
	public Theme createTheme(Theme theme);
	public Theme updateTheme(Theme theme);
	public void deleteTheme(long id);
}

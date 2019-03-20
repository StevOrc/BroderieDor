package com.broderieDor.service;

import java.util.List;

import com.broderieDor.model.basket.Basket;
import com.broderieDor.model.product.Product;
import com.broderieDor.model.theme.Theme;
import com.broderieDor.model.user.User;


public interface IServices {

	//Global Service for product
	public List<Product> allProducts();
	public List<Product> productByName(String name);
	public long countProduct();
	
	
	//Themes
	public List<Theme> allThemes();
	public long themeSize();
	
	public List<Basket> allPanniers();
	public List<User> allClients();
}

package com.broderieDor.web.servicesController;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.broderieDor.model.basket.Basket;
import com.broderieDor.model.product.Product;
import com.broderieDor.model.theme.Theme;
import com.broderieDor.service.IServices;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ServicesController {

	
	@Autowired
	IServices services;
	
	@GetMapping("/themes")
	public ResponseEntity<?> getAllThemes(){
		
		if(this.services.themeSize() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Theme>>(this.services.allThemes(), HttpStatus.OK);
	}

	@GetMapping("/panier")
	public List<Basket> getAllPanier(){
		
//		if(services.countProduct() == 0)
//			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//		else
//			return new ResponseEntity<List<Produit>>(services.allProducts(), HttpStatus.OK);
		return services.allPanniers();
	}
	
	@GetMapping("/produit")
	public List<Product> getAllProduct(){
		
		return this.services.allProducts();
	}
}

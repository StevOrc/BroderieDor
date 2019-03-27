package com.broderieDor.web.servicesController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.broderieDor.JSONresponse.JSONresponse;
import com.broderieDor.dto.BasketDto;
import com.broderieDor.model.basket.Basket;
import com.broderieDor.model.product.Product;
import com.broderieDor.model.theme.Theme;
import com.broderieDor.model.user.User;
import com.broderieDor.service.IAdminService;
import com.broderieDor.service.IServices;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	IServices services;
	
	@Autowired
	IAdminService adminService;
	
	// Product management
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/product")
	public ResponseEntity<?> allProduct(){
		
		return new ResponseEntity<List<Product>>(this.services.allProducts(), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/product/create")
	public ResponseEntity<?> createProduct(@RequestBody Product product){
		
		return new ResponseEntity<Product>(this.adminService.addProduct(product), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/product/update")
	public ResponseEntity<?> updateProduct(@RequestBody Product product){
		
		return new ResponseEntity<Product>(this.adminService.updateProduct(product), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/product/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable long  id){
		this.adminService.removeProduct(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	//THEME MANAGEMENT
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/theme")
	public ResponseEntity<?> getAllTheme(){
		
		return new ResponseEntity<List<Theme>>(this.services.allThemes(), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/theme/create")
	public ResponseEntity<?> createTheme(@RequestBody Theme theme){
		
		return new ResponseEntity<Theme>(this.adminService.createTheme(theme), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/theme/update")
	public ResponseEntity<?> updateTheme(@RequestBody Theme theme){
		
		return new ResponseEntity<Theme>(this.adminService.updateTheme(theme), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/theme/{id}")
	public ResponseEntity<?> deleteTheme(@PathVariable long id){
		
		this.adminService.deleteTheme(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	//BASKET MANAGEMENT
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/basket")
	public ResponseEntity<?> getAllBasket(){
		
		return new ResponseEntity<List<Basket>>( this.adminService.readAllBasket(), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/basket/create")
	public ResponseEntity<?> createBasket(@RequestBody BasketDto basketDto){
		if(basketDto == null)
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		else {
			return new ResponseEntity<Basket>(this.adminService.convertBasketDtoToBasket(basketDto), HttpStatus.OK);
		}
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/basket/update")
	public ResponseEntity<?> updateBasket(@RequestBody BasketDto basketDto){
		if(basketDto == null)
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		else {
			return new ResponseEntity<Basket>(this.adminService.convertBasketDtoToBasket(basketDto), HttpStatus.OK);
		}
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/basket/{id}")
	public ResponseEntity<?> deleteBasket(@PathVariable long id){
		
		this.adminService.deletBasket(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	//User Management
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers(){
	
		return new ResponseEntity<List<User>>(this.adminService.getAllUsers(),HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable long id){
	
		this.adminService.deleteUser(id);
		return new ResponseEntity<JSONresponse>(new JSONresponse("Utilisateur supprimé avec succès"),HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/users/validate/{id}")
	public ResponseEntity<?> validateUser(@PathVariable long id){
	
		User user = this.adminService.getUserById(id);
		if(user != null) {
			user.setValid(true);
			user.setPromotion(true);
			this.adminService.validAccount(user);
		}
		return new ResponseEntity<JSONresponse>(new JSONresponse("Compte utilisateur validé"),HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/users/addpromo/{id}")
	public ResponseEntity<?> addPromo(@PathVariable long id){
	
		User user = this.adminService.getUserById(id);
		if(user != null) {
			user.setPromotion(true);
			this.adminService.validAccount(user);
		}
		return new ResponseEntity<JSONresponse>(new JSONresponse("Opération validée, promo accordée"),HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/users/deletepromo/{id}")
	public ResponseEntity<?> deletePromo(@PathVariable long id){
	
		User user = this.adminService.getUserById(id);
		if(user != null) {
			user.setPromotion(false);
			this.adminService.validAccount(user);
		}
		return new ResponseEntity<JSONresponse>(new JSONresponse("Opération validée, promo supprimée"),HttpStatus.OK);
	}
}

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

import com.broderieDor.model.product.Product;
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
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/product")
	public ResponseEntity<?> allProduct(){
		
		return new ResponseEntity<List<Product>>(this.services.allProducts(), HttpStatus.OK);
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
}

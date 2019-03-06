package com.broderieDor.model.product;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.broderieDor.model.basketLine.BasketLine;
import com.broderieDor.model.commande.OrderLine;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProduct;
	
	@NotBlank
	@Length(max = 255)
	private String name;
	
	@NotNull
	private float price;
	
	@NotNull
	@Column(columnDefinition = "int default 0")
	private int stock;
	
	@NotBlank
	@Length(max = 100)
	private String urlPhoto;
	
	
	@OneToMany(mappedBy="product")
	@JsonIgnore
	private List<OrderLine> orderLines;
	
	@OneToMany(mappedBy="product")
	@JsonIgnore
	private List<BasketLine> basketLines;

	//Constuctors
	public Product() {
			
	}

	public Product(@NotBlank @Length(max = 255) String name, @NotNull float price, @NotNull int stock,
			@NotBlank @Length(max = 100) String urlPhoto) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.urlPhoto = urlPhoto;
	}

	//GETTERS - SETTERS
	public long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public List<BasketLine> getBasketLines() {
		return basketLines;
	}

	public void setBasketLines(List<BasketLine> basketLines) {
		this.basketLines = basketLines;
	}
		
}

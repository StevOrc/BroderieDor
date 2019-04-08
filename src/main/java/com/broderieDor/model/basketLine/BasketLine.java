package com.broderieDor.model.basketLine;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.broderieDor.model.basket.Basket;
import com.broderieDor.model.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BasketLine {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long  idBasketLine;
	
	@ManyToOne
	@JoinColumn(name="idProduct")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="idBasket")
	@JsonIgnore
	private Basket basket;
	
	private int quantity;
	
	public  BasketLine() {
		
	}

	public BasketLine(Product product, Basket basket, int quantity) {
		super();
		this.product = product;
		this.basket = basket;
		this.quantity = quantity;
	}

	// GETTERS - SETTERS

	public long getIdBasketLine() {
		return idBasketLine;
	}

	public void setIdBasketLine(long idBasketLine) {
		this.idBasketLine = idBasketLine;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}

package com.broderieDor.model.commande;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.broderieDor.model.basket.Basket;
import com.broderieDor.model.product.Product;

@Entity
public class OrderLine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idOrderLine;
	
	@NotNull
	private int quantity;
	
	@NotNull
	private float price;
	
	@ManyToOne
	@JoinColumn(name="idbasket")
	private Basket basket;
	
	@ManyToOne
	@JoinColumn(name="idcommande")
	private Commande commande;

	@ManyToOne
	@JoinColumn(name="idproduct")
	private Product product;
	
	//Constructors
	public OrderLine() {
		
	}

	public OrderLine(@NotNull int quantity, @NotNull float price, Basket basket, Commande commande, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.basket = basket;
		this.commande = commande;
		this.product = product;
	}

	//GETTERS - SETTERS
	public long getIdOrderLine() {
		return idOrderLine;
	}

	public void setIdOrderLine(int idOrderLine) {
		this.idOrderLine = idOrderLine;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}	
	
	
	
}

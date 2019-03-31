package com.broderieDor.model.basket;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.broderieDor.model.basketLine.BasketLine;
import com.broderieDor.model.theme.Theme;


@Entity
public class Basket {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idBasket;
	
	@NotBlank
	@Length(max=50)
	private String name;

	@NotNull
	private float price;
	
	@ManyToOne
	@JoinColumn(name="idTheme")
	private Theme theme;

	@NotBlank
	@Length(max = 100)
	private String urlPhoto;
	
	@OneToMany(mappedBy="basket")
	private List<BasketLine> basketLines;


	//CONSTRUCTORS
	public Basket() {
		
	}

	
	public Basket(@NotBlank @Length(max = 50) String name, @NotNull float price, Theme theme, String urlPhoto) {
		this.name = name;
		this.price = price;
		this.theme = theme;
		this.urlPhoto = urlPhoto;
	}

	//GETTERS - SETTERS
	public long getIdBasket() {
		return idBasket;
	}


	public void setIdBasket(long idBasket) {
		this.idBasket = idBasket;
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


	public Theme getTheme() {
		return theme;
	}


	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	
	

	public String getUrlPhoto() {
		return urlPhoto;
	}


	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}


	public List<BasketLine> getBasketLines() {
		return basketLines;
	}


	public void setBasketLine(List<BasketLine> basketLines) {
		this.basketLines = basketLines;
	}

	
}

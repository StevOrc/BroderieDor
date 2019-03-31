package com.broderieDor.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;


public class BasketDto {
	
	private long IdBasket;
	
    @NotBlank
	private String name;
	
    @NotBlank
	private String theme;
	
    @NotBlank
	private float price;
    
    @NotBlank
	private String urlPhoto;

	private List<BasketLineDto> basketLines;

	public BasketDto() {
		
	}

	
	public BasketDto(@NotBlank String name, @NotBlank String theme, @NotBlank float price, String urlPhoto,
			List<BasketLineDto> basketLines) {
		this.name = name;
		this.theme = theme;
		this.price = price;
		this.basketLines = basketLines;
		this.urlPhoto = urlPhoto;
	}

	//GETTERS - SETTERS
	public long getIdBasket() {
		return IdBasket;
	}

	public void setIdBasket(long idBasket) {
		IdBasket = idBasket;
	}

	public List<BasketLineDto> getBasketLines() {
		return basketLines;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}


	public List<BasketLineDto> getBasketLine() {
		return basketLines;
	}

    public String getUrlPhoto() {
		return urlPhoto;
	}


	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public void setBasketLines(List<BasketLineDto> basketLines) {
		this.basketLines = basketLines;
	}

	public void displayAllLines() {
		for(BasketLineDto line: basketLines) {
			System.out.println(line.getIdProduct()+ " / " +line.getQuantity());
		}
	}
	
}

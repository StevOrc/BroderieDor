package com.broderieDor.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BasketLineDto {
	
	private long idBasketLine;
	
    @NotNull
	private int quantity;
	
    @NotNull
	private long idProduct;

    public BasketLineDto() {
    	
    }
    
	public BasketLineDto(@NotNull int quantity, @NotNull long idProduct) {
		this.quantity = quantity;
		this.idProduct = idProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}

	public long getIdBasketLine() {
		return idBasketLine;
	}

	public void setIdBasketLine(long idBasketLine) {
		this.idBasketLine = idBasketLine;
	}
	
	
    
}

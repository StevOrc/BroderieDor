package com.broderieDor.dto;

import javax.validation.constraints.NotBlank;

public class BasketLineDto {
	
    @NotBlank
	private int quantity;
	
    @NotBlank
	private long idProduct;

    public BasketLineDto() {
    	
    }
    
	public BasketLineDto(@NotBlank int quantity, @NotBlank long idProduct) {
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
	
	
    
}

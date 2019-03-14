package com.broderieDor.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.broderieDor.dto.BasketDto;
import com.broderieDor.dto.BasketLineDto;
import com.broderieDor.model.basket.Basket;
import com.broderieDor.model.basketLine.BasketLine;
import com.broderieDor.repository.BasketLineRepository;
import com.broderieDor.service.IAdminService;

@Component
public class BasketConverter implements Converter<BasketDto, Basket>{

	@Autowired
	IAdminService adminService;
	
	@Autowired
	BasketLineRepository basketLineRepo;
	
	@Override
	public Basket convert(BasketDto basketDto) {
		
		Basket basket = new Basket();
		if(basketDto.getIdBasket() != 0) {
			basket.setIdBasket(basketDto.getIdBasket());
		}
		basket.setName(basketDto.getName());
		basket.setTheme(this.adminService.findThemeByName(basketDto.getTheme()));
		basket.setPrice(basketDto.getPrice());
		this.adminService.createBasket(basket);
		
		System.out.println(basketDto.getBasketLine());
		
		for(BasketLineDto line : basketDto.getBasketLine()) {
			BasketLine basketLine = new BasketLine();
			if(line.getIdBasketLine() != 0)
				basketLine.setIdBasketLine(line.getIdBasketLine());
			basketLine.setBasket(this.adminService.findBasketById(basket.getIdBasket()));
			basketLine.setProduct(this.adminService.findProductById(line.getIdProduct()));
			basketLine.setQuantity(line.getQuantity());
			this.basketLineRepo.save(basketLine);
		}
		
		return this.adminService.createBasket(basket);
	}

}

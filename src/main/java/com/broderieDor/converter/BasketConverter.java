package com.broderieDor.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.broderieDor.dto.BasketDto;
import com.broderieDor.model.basket.Basket;

@Component
public class BasketConverter implements Converter<BasketDto, Basket>{

	@Override
	public Basket convert(BasketDto source) {
		
		return null;
	}

}

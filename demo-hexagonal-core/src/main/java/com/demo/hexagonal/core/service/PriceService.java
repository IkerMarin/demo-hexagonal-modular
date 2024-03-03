package com.demo.hexagonal.core.service;

import java.time.LocalDateTime;

import com.demo.hexagonal.domain.data.Price;

public interface PriceService {
	
	Price getPriceByBrandProductAndDate(Integer idBrand, Integer idProduct, LocalDateTime date);

}

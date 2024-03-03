package com.demo.hexagonal.domain.port;

import java.time.LocalDateTime;

import com.demo.hexagonal.domain.data.Price;

public interface PricePersistencePort {
	
	Price getPriceByBrandProductAndDate(Integer id, Integer idBrand, LocalDateTime eventDate);

}

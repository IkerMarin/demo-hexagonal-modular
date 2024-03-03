package com.demo.hexagonal.domain.data.port;

import java.time.LocalDateTime;

import com.demo.hexagonal.domain.data.Price;

public interface PricePersistencePort {
	
	Price getPriceById(Integer id, Integer idBrand, LocalDateTime eventDate);

}

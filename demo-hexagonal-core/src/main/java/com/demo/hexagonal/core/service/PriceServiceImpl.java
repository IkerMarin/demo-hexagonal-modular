package com.demo.hexagonal.core.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.hexagonal.domain.data.Price;
import com.demo.hexagonal.domain.port.PricePersistencePort;

@Service
public class PriceServiceImpl implements PriceService{
	
	@Autowired
	private PricePersistencePort pricePersistencePort;

	@Override
	public Price getPriceByBrandProductAndDate(Integer idBrand, Integer idProduct, LocalDateTime date) {
		return pricePersistencePort.getPriceByBrandProductAndDate(idProduct, idBrand, date);
	}

}

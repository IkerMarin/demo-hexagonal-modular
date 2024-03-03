package com.demo.hexagonal.dataaccess.adapter;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.hexagonal.dataaccess.mapper.PriceDataAccessMapper;
import com.demo.hexagonal.dataaccess.model.PriceEntity;
import com.demo.hexagonal.dataaccess.repository.PricesRepository;
import com.demo.hexagonal.domain.data.Price;
import com.demo.hexagonal.domain.exception.PriceNotFoundException;
import com.demo.hexagonal.domain.port.PricePersistencePort;

@Service
public class PriceDataAccessAdapter implements PricePersistencePort {
	
	@Autowired
	private PricesRepository pricesRepository;
	
	@Autowired
	private PriceDataAccessMapper mapper;

	@Override
	public Price getPriceByBrandProductAndDate(Integer idBrand, Integer idProduct, LocalDateTime eventDate) {
		List<PriceEntity> result = pricesRepository.findPriceByBrandProductAndEventDate(idBrand, idProduct, eventDate);
		Optional<PriceEntity> priceEntityFiltered = result.stream().sorted(Comparator.comparing(PriceEntity::getPriority).reversed()).findFirst();
		
		if(!priceEntityFiltered.isPresent()) {
			throw new PriceNotFoundException();
		}
		
		
		return mapper.priceEntityToPrice(priceEntityFiltered.get());
	}

}

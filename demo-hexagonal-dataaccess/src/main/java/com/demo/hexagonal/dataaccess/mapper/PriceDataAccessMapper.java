package com.demo.hexagonal.dataaccess.mapper;

import org.springframework.stereotype.Component;

import com.demo.hexagonal.dataaccess.model.PriceEntity;
import com.demo.hexagonal.domain.data.Price;

@Component
public class PriceDataAccessMapper {
	
	public Price priceEntityToPrice (PriceEntity priceEntity) {
        return Price .builder()
        		.id(priceEntity.getId())
        		.idBrand(priceEntity.getIdBrand())
        		.idProduct(priceEntity.getIdProduct())
        		.price(priceEntity.getPrice())
        		.priceType(priceEntity.getPriceType())
        		.priority(priceEntity.getPriority())
        		.startDate(priceEntity.getStartDate())
        		.endDate(priceEntity.getEndDate())
                .build();
    }

}

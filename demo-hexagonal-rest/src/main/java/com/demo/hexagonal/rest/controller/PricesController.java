package com.demo.hexagonal.rest.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.hexagonal.core.service.PriceService;
import com.demo.hexagonal.domain.data.Price;
import com.demo.hexagonal.rest.util.ApiConstants;
import com.demo.hexagonal.rest.util.GeneralUtils;

import io.micrometer.common.util.StringUtils;

@RestController
@RequestMapping(ApiConstants.PRICES_CONTROLLER_PATH)
public class PricesController {
	
	@Autowired
	private PriceService pricesService;

    @GetMapping(ApiConstants.GET_PRICE_ENDPOINT)
    public ResponseEntity<?> getPrice(Integer idBrand, Integer idProduct, String eventDate){
    	
    	if(null == idBrand || null == idProduct || StringUtils.isBlank(eventDate)){
    		throw new IllegalArgumentException();
    	}
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(GeneralUtils.YYYY_MM_DD_HH_MM_SS_PATTERN);
    	
    	LocalDateTime specificDate = null;
    	
    	try{
    		specificDate = LocalDateTime.parse(eventDate, formatter);
    	}catch(DateTimeParseException e) {
    		throw e;
    	}
    	
    	Price price = pricesService.getPriceByBrandProductAndDate(idBrand, idProduct, specificDate);
    	
        return ResponseEntity.ok(price);
    }

}

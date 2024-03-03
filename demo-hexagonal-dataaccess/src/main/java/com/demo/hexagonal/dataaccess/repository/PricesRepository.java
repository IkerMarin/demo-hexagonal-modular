package com.demo.hexagonal.dataaccess.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.hexagonal.dataaccess.model.PriceEntity;

@Repository
public interface PricesRepository extends JpaRepository<PriceEntity, Integer> {

	List<PriceEntity> findByIdBrand(Integer idBrand);
	List<PriceEntity> findByIdBrandAndIdProduct(Integer idBrand, Integer idProduct);
	
	/**
	 * Retrieves all records from PRICES table that meet the specified idBrand, idProduct and 
	 * are active on the specified date
	 * 
	 * @param idBrand Brand identifier
	 * @param idProduct Product identifier
	 * @param eventDate Search date for the desired Price records
	 */
	@Query(value = "SELECT * FROM PRICES "
			+ "WHERE BRAND_ID = :idBrand "
			+ "AND PRODUCT_ID = :idProduct "
			+ "AND :eventDate BETWEEN START_DATE AND END_DATE ", nativeQuery = true)
	List<PriceEntity> findPriceByBrandProductAndEventDate(Integer idBrand, Integer idProduct, LocalDateTime eventDate);
	
}

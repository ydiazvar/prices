package com.comercio.electronico.prices.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.comercio.electronico.prices.model.Prices;
import com.comercio.electronico.prices.repository.PriceRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PricesServiceImpl implements PricesService{
	
	@Autowired
	private PriceRepository priceRepository;

	@Override
	public Prices consultProductByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfter(Long brandId, Long productId,
			LocalDateTime date) {
		var price = this.priceRepository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(brandId, productId, date, date)
				.orElseThrow(() -> new EntityNotFoundException("Producto no encontrado")); 
		return price;
	}

}

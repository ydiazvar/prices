package com.comercio.electronico.prices.service;

import java.time.LocalDateTime;

import com.comercio.electronico.prices.model.Prices;

public interface PricesService {
	
	Prices consultProductByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfter(Long brandId, Long productId, LocalDateTime date);

}

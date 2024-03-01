package com.comercio.electronico.prices.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comercio.electronico.prices.model.Prices;

@Repository
public interface PriceRepository extends JpaRepository<Prices, Long> {
	
    Optional<Prices> findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
            Long brandId, Long productId, LocalDateTime date, LocalDateTime date2);
    
}
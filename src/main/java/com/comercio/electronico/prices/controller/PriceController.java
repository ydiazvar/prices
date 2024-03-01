package com.comercio.electronico.prices.controller;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comercio.electronico.prices.model.Prices;
import com.comercio.electronico.prices.service.PricesService;

/**
 * @author Yonny Diaz Vargas
 * @descripcion Prueba Tecnica
 * @version 1.0
 */
@RestController
@RequestMapping("/prices")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class PriceController {
	
    @Autowired
    private PricesService pricesService;

    @GetMapping
    public ResponseEntity<?> getPrices(
            @RequestParam(name = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
            @RequestParam(name = "productId") Long productId,
            @RequestParam(name = "brandId") Long brandId) {
    	try {
        Prices prices = this.pricesService
                .consultProductByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfter(brandId, productId, date);
        return ResponseEntity.ok(prices);
    	} catch(Exception ex) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro servidor: " + ex.getMessage());
    	}
        
    }
}

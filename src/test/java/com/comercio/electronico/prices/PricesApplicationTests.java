package com.comercio.electronico.prices;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.comercio.electronico.prices.model.Prices;
import com.comercio.electronico.prices.repository.PriceRepository;
import com.comercio.electronico.prices.service.PricesService;
import com.comercio.electronico.prices.service.PricesServiceImpl;

@SpringBootTest
class PricesApplicationTests {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PricesServiceImpl pricesServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void casoDePrueba1() {
        LocalDateTime dateTime = LocalDateTime.of(2020, 6, 14, 10, 0); 
        Long productId = 35455L;
        Long brandId = 1L;

        when(priceRepository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(brandId,
                productId, dateTime, dateTime)).thenReturn(java.util.Optional.empty());

        Prices prices = pricesServiceImpl.consultProductByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfter(productId, brandId, dateTime);
        assertThat(prices).isNotNull();
    }


}

package com.inditex.productprice.api.application.service;


import com.inditex.productprice.api.domain.entity.Price;
import com.inditex.productprice.api.domain.model.PriceDTO;
import com.inditex.productprice.api.domain.service.PriceRepository;
import com.inditex.productprice.api.infrastructure.service.PriceRepositoryAdapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductPriceServiceTest {

    @Mock
    private PriceRepositoryAdapter priceRepository;

    @InjectMocks
    private ProductPriceService productPriceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void test1_PriceAt10AMOn14th() {
        LocalDateTime dateIni = LocalDateTime.of(2020, 6, 14, 10, 0);
        LocalDateTime dateEnd = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
        Price price = new Price(1, 35455, dateIni, dateEnd , 1, 0, 35.50, "EUR");
        when(priceRepository.findValidPrices(35455, 1, dateIni)).thenReturn(List.of(price));

        Optional<PriceDTO> result = productPriceService.getApplicablePrice(35455, 1, dateIni);
        assertEquals(35.50, result.get().getPrice());
    }

    @Test
    void test2_PriceAt16PMOn14th() {
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 16, 0);
        Price price = new Price(1, 35455, date, LocalDateTime.of(2020, 6, 14, 18, 30), 2, 1, 25.45, "EUR");
        when(priceRepository.findValidPrices(35455, 1, date)).thenReturn(List.of(price));

        Optional<PriceDTO> result = productPriceService.getApplicablePrice(35455, 1, date);
        assertEquals(25.45, result.get().getPrice());
    }

    @Test
    void test3_PriceAt21PMOn14th() {
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 21, 0);
        Price price = new Price(1, 35455, date, LocalDateTime.of(2020, 12, 31, 23, 59, 59), 1, 0, 35.50, "EUR");
        when(priceRepository.findValidPrices(35455, 1, date)).thenReturn(List.of(price));

        Optional<PriceDTO> result = productPriceService.getApplicablePrice(35455, 1, date);
        assertEquals(35.50, result.get().getPrice());
    }

    @Test
    void test4_PriceAt10AMOn15th() {
        LocalDateTime date = LocalDateTime.of(2020, 6, 15, 10, 0);
        Price price = new Price(1, 35455, date, LocalDateTime.of(2020, 6, 15, 11, 0), 3, 1, 30.50, "EUR");
        when(priceRepository.findValidPrices(35455, 1, date)).thenReturn(List.of(price));

        Optional<PriceDTO> result = productPriceService.getApplicablePrice(35455, 1, date);
        assertEquals(30.50, result.get().getPrice());
    }

    @Test
    void test5_PriceAt21PMOn16th() {
        LocalDateTime date = LocalDateTime.of(2020, 6, 16, 21, 0);
        Price price = new Price(1, 35455, date, LocalDateTime.of(2020, 12, 31, 23, 59, 59), 4, 1, 38.95, "EUR");
        when(priceRepository.findValidPrices(35455, 1, date)).thenReturn(List.of(price));

        Optional<PriceDTO> result = productPriceService.getApplicablePrice(35455, 1, date);
        assertEquals(38.95, result.get().getPrice());
    }

}

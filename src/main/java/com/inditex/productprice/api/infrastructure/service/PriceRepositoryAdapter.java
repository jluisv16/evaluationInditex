package com.inditex.productprice.api.infrastructure.service;

import com.inditex.productprice.api.domain.entity.Price;
import com.inditex.productprice.api.domain.service.PriceRepository;
import com.inditex.productprice.api.infrastructure.repository.JpaPriceRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class PriceRepositoryAdapter implements PriceRepository {

    private final JpaPriceRepository jpaPriceRepository;

    public PriceRepositoryAdapter(JpaPriceRepository jpaPriceRepository) {
        this.jpaPriceRepository = jpaPriceRepository;
    }


    public List<Price> findValidPrices(Integer productId, Integer brandId, LocalDateTime date) {
        return jpaPriceRepository.findValidPrices(productId, brandId, date);
    }
}

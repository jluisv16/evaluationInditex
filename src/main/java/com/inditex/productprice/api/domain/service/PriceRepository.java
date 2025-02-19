package com.inditex.productprice.api.domain.service;

import com.inditex.productprice.api.domain.entity.Price;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository {

    List<Price> findValidPrices(Integer productId, Integer brandId, LocalDateTime date);
}

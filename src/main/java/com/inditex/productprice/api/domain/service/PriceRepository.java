package com.inditex.productprice.api.domain.service;

import com.inditex.productprice.api.domain.entity.Price;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;


@Repository
public interface PriceRepository {

    Optional<Price> findPriceByProductAndBrandAndDate(Integer productId, Integer brandId, LocalDateTime date);
}

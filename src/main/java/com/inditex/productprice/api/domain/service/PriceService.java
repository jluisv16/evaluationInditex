package com.inditex.productprice.api.domain.service;

import com.inditex.productprice.api.domain.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;


@Repository
public interface PriceService   {

    Optional<Price> findPriceByProductAndBrandAndDate(Long productId, Long brandId, LocalDateTime date);
}

package com.inditex.productprice.api.infrastructure.repository;

import com.inditex.productprice.api.domain.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface JpaPriceRepository extends JpaRepository<Price, Integer> {

    /*Optional<Price> findFirstByProductIdAndBrandIdAndStartDateByPriorityDesc(
            Integer productId,
            Integer brandId,
            LocalDateTime applicationDate
    );*/

    List<Price> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            Integer productId,
            Integer brandId,
            LocalDateTime applicationDate);
}

package com.inditex.productprice.api.infrastructure.repository;

import com.inditex.productprice.api.domain.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface JpaPriceRepository extends JpaRepository<Price, Integer> {

    /*Optional<Price> findFirstByProductIdAndBrandIdAndStartDateByPriorityDesc(
            Integer productId,
            Integer brandId,
            LocalDateTime applicationDate
    );*/

    /*List<Price> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            Integer productId,
            Integer brandId,
            LocalDateTime applicationDate);*/

    @Query("SELECT p FROM Price p WHERE p.productId = :productId AND p.brandId = :brandId " +
            "AND :date BETWEEN p.startDate AND p.endDate " +
            "ORDER BY p.priority DESC")
    List<Price> findValidPrices(@Param("productId") Integer productId,
                                @Param("brandId")Integer brandId,
                                @Param("date") LocalDateTime date);

}

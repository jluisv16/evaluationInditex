package com.inditex.productprice.api.application.service;

import com.inditex.productprice.api.domain.entity.Price;
import com.inditex.productprice.api.domain.model.PriceDTO;
import com.inditex.productprice.api.infrastructure.service.PriceRepositoryAdapter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductPriceService {

    private final PriceRepositoryAdapter priceRepository;

    public ProductPriceService(PriceRepositoryAdapter priceRepository) {
        this.priceRepository = priceRepository;
    }

public Optional<PriceDTO> getApplicablePrice(Integer productId, Integer brand, LocalDateTime date) {
        // Lógica de negocio para obtener el precio del
        // producto según la fecha, producto y marca
    List<Price> pricesList  = priceRepository
                .findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(productId, brand, date);

    if (!pricesList.isEmpty()) {
        return pricesList.stream().findFirst().map(this::toDto);
    }
    return null;
}

private PriceDTO toDto(Price price) {
    return new PriceDTO(
            price.getBrandId(),
            price.getProductId(),
            price.getStartDate(),
            price.getEndDate(),
            price.getPriceList(),
            price.getPrice(),
            price.getCurrency()
    );
}



}

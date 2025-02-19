package com.inditex.productprice.api.application.service;



import com.inditex.productprice.api.infrastructure.service.PriceRepositoryAdapter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProductPriceService {

    private final PriceRepositoryAdapter priceRepository;

    public ProductPriceService(PriceRepositoryAdapter priceRepository) {
        this.priceRepository = priceRepository;
    }

public Optional findPriceByProductAndBrandAndDate(Integer productId, Integer brand, LocalDateTime date) {
        // Lógica de negocio para obtener el precio del producto según la fecha, producto y marca
        return priceRepository.findPriceByProductAndBrandAndDate(productId, brand, date);
    }

}

package com.inditex.productprice.api.application.service;

import com.inditex.productprice.api.domain.model.PriceDTO;
import com.inditex.productprice.api.domain.service.PriceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductPriceService {

    private final PriceRepository priceRepository;

    public ProductPriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

public Optional getPriceForProduct(Integer productId, Integer brand, String date) {
        // Lógica de negocio para obtener el precio del producto según la fecha, producto y marca
        return priceRepository.findPriceByProductAndBrandAndDate(productId, brand, date);
    }

}

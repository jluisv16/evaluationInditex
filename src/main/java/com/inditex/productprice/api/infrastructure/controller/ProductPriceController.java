package com.inditex.productprice.api.infrastructure.controller;

import com.inditex.productprice.api.application.service.ProductPriceService;
import com.inditex.productprice.api.domain.model.PriceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class ProductPriceController {

    private final ProductPriceService productPriceService;

    public ProductPriceController(ProductPriceService productPriceService) {
        this.productPriceService = productPriceService;
    }

    @GetMapping("/prices")
    public ResponseEntity<PriceDTO> getPrice(
            @RequestParam String applicationDate,
            @RequestParam Integer productId,
            @RequestParam Integer brandId) {

        LocalDateTime date = LocalDateTime.parse(applicationDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));

        return (ResponseEntity<PriceDTO>)
                productPriceService.findPriceByProductAndBrandAndDate(productId, brandId, date)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}

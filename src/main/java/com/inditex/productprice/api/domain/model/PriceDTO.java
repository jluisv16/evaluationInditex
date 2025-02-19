package com.inditex.productprice.api.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
public class PriceDTO {

    private Integer brandId;
    private Integer productId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priceList;
    private double price;
    private String currency;


    public PriceDTO(Integer brandId, Integer productId, LocalDateTime startDate, LocalDateTime endDate, Integer priceList, double price, String currency) {
        this.brandId = brandId;
        this.productId = productId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.price = price;
        this.currency = currency;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public void setPriceList(Integer priceList) {
        this.priceList = priceList;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}

package com.inditex.productprice.api.domain.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@Table(name = "price")
public class Price {

    @Id
    private Long id;

    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "price_list")
    private Integer priceList;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "price")
    private double price;

    @Column(name = "currency")
    private String currency;

    public Price(Long id, Integer brandId, Integer productId, LocalDateTime startDate, LocalDateTime endDate, Integer priceList, Integer priority, double price, String currency) {
        this.id = id;
        this.brandId = brandId;
        this.productId = productId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }

    public Price(Integer brandId, Integer productId, LocalDateTime startDate, LocalDateTime endDate, int priority, double price, String currency) {
        this.brandId = brandId;
        this.productId = productId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }

    public Price(Integer brandId, Integer productId, LocalDateTime startDate, LocalDateTime endDate, int priceList, int priority, double price, String currency) {
        this.brandId = brandId;
        this.productId = productId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public Integer getProductId() {
        return productId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public Integer getPriority() {
        return priority;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setPriceList(Integer priceList) {
        this.priceList = priceList;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}

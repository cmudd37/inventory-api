package com.cam.inventory_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductRequest {
    @NotBlank
    private String name;

    @NotBlank
    private Long supplierId;

    @NotNull
    private Long categoryId;

    @NotNull
    private double price;

    @Min(0)
    private Integer currentStock;

    public ProductRequest() {}

    public ProductRequest(String name, Long supplierId, Long categoryId, double price, Integer currentStock) {
        this.name = name;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
        this.price = price;
        this.currentStock = currentStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

}

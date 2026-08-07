package com.cam.inventory_api.dto;

public class ProductResponse {
    private Long productId;
    private String productName;
    private Long supplierId;
    private String supplier;
    private Long categoryId;
    private String category;
    private double price;
    private Integer currentStock;

    public ProductResponse() {}

    public ProductResponse(Long productId, String productName, Long supplierId, String supplier, Long categoryId, String category, double price, Integer currentStock) {
        this.productId = productId;
        this.productName = productName;
        this.supplier = supplier;
        this.category = category;
        this.price = price;
        this.currentStock = currentStock;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
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

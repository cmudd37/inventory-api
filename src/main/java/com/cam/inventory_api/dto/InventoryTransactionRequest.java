package com.cam.inventory_api.dto;

import com.cam.inventory_api.enums.TransactionType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class InventoryTransactionRequest {
    @NotNull
    private Long productId;

    @NotNull
    private Long warehouseId;

    @NotNull
    @Min(value = 1)
    private Integer quantity;

    @NotNull
    private TransactionType transactionType;

    public InventoryTransactionRequest(Long productId, Long warehouseId, Integer quantity, TransactionType transactionType) {
        this.productId = productId;
        this.warehouseId = warehouseId;
        this.quantity = quantity;
        this.transactionType = transactionType;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType= transactionType;
    }

}

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
    private Integer transactionQuantity;

    @NotNull
    private TransactionType transactionType;

    public InventoryTransactionRequest(Long productId, Long warehouseId, Integer transactionQuantity, TransactionType transactionType) {
        this.productId = productId;
        this.warehouseId = warehouseId;
        this.transactionQuantity = transactionQuantity;
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

    public Integer getTransactionQuantity() {
        return transactionQuantity;
    }

    public void setQuantity(Integer transactionQuantity) {
        this.transactionQuantity = transactionQuantity;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType= transactionType;
    }

}

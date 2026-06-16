package com.cam.inventory_api.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class InventoryTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private LocalDateTime transactionDate;
    private String transactionType;

    public InventoryTransaction() {}

    public InventoryTransaction(Long id, Integer quantity, LocalDateTime transactionDate, String transactionType) {
        this.id = id;
        this.quantity = quantity;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

}

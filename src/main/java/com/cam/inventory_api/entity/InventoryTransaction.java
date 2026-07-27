package com.cam.inventory_api.entity;

import com.cam.inventory_api.enums.TransactionType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class InventoryTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer transactionQuantity;
    private LocalDateTime transactionDate;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;


    public InventoryTransaction() {}

    public InventoryTransaction(Product product, Warehouse warehouse, Integer transactionQuantity, TransactionType transactionType, LocalDateTime transactionDate) {
        this.product = product;
        this.warehouse = warehouse;
        this.transactionQuantity = transactionQuantity;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTransactionQuantity() {
        return transactionQuantity;
    }

    public void setTransactionQuantity(Integer quantity) {
        this.transactionQuantity = quantity;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

}

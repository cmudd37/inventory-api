package com.cam.inventory_api.service.impl;

import com.cam.inventory_api.dto.InventoryTransactionRequest;
import com.cam.inventory_api.dto.InventoryTransactionResponse;
import com.cam.inventory_api.entity.InventoryTransaction;
import com.cam.inventory_api.entity.Product;
import com.cam.inventory_api.entity.Warehouse;
import com.cam.inventory_api.enums.TransactionType;
import com.cam.inventory_api.repository.InventoryTransactionRepository;
import com.cam.inventory_api.repository.ProductRepository;
import com.cam.inventory_api.repository.WarehouseRepository;
import com.cam.inventory_api.service.InventoryTransactionService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InventoryTransactionServiceImpl implements InventoryTransactionService {

    private final ProductRepository productRepository;
    private final WarehouseRepository warehouseRepository;
    private final InventoryTransactionRepository inventoryTransactionRepository;

    public InventoryTransactionServiceImpl(ProductRepository productRepository, WarehouseRepository warehouseRepository, InventoryTransactionRepository inventoryTransactionRepository) {
        this.productRepository = productRepository;
        this.warehouseRepository = warehouseRepository;
        this.inventoryTransactionRepository = inventoryTransactionRepository;
    }

    @Override
    public InventoryTransactionResponse createTransaction(InventoryTransactionRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Warehouse warehouse = warehouseRepository.findById(request.getWarehouseId())
                .orElseThrow(() -> new RuntimeException("Warehouse not found."));

        if (request.getTransactionType() == TransactionType.SALE && request.getTransactionQuantity() > product.getCurrentStock()) {
            throw new RuntimeException("Insufficient inventory.");
        }

        InventoryTransaction transaction = new InventoryTransaction(
                product,
                warehouse,
                request.getTransactionQuantity(),
                request.getTransactionType(),
                LocalDateTime.now()
        );


        switch (request.getTransactionType()) {
            case PURCHASE, RETURN -> product.setCurrentStock(product.getCurrentStock() + request.getTransactionQuantity());
            case SALE -> product.setCurrentStock(product.getCurrentStock() - request.getTransactionQuantity());
            case ADJUSTMENT -> product.setCurrentStock(request.getTransactionQuantity());
        }

        productRepository.save(product);

        InventoryTransaction savedTransaction = inventoryTransactionRepository.save(transaction);

        return mapToResponse(savedTransaction);

    }

    @Override
    public InventoryTransactionResponse getTransactionById(Long id) {
        InventoryTransaction inventoryTransaction = inventoryTransactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory transaction not found."));

        return mapToResponse(inventoryTransaction);
    }

    @Override
    public List<InventoryTransactionResponse> getAllTransactions() {
        return inventoryTransactionRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<InventoryTransactionResponse> getTransactionsByProduct(Long productId) {
        productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found."));

        return inventoryTransactionRepository.findByProductId(productId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public InventoryTransactionResponse mapToResponse(InventoryTransaction transaction) {
        return new InventoryTransactionResponse(
                transaction.getId(),
                transaction.getProduct().getId(),
                transaction.getProduct().getName(),
                transaction.getWarehouse().getId(),
                transaction.getWarehouse().getName(),
                transaction.getTransactionQuantity(),
                transaction.getTransactionType(),
                transaction.getTransactionDate()
        );
    }
}

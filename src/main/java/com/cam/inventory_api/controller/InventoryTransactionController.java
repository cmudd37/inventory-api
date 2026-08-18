package com.cam.inventory_api.controller;

import com.cam.inventory_api.dto.InventoryTransactionRequest;
import com.cam.inventory_api.dto.InventoryTransactionResponse;
import com.cam.inventory_api.service.InventoryTransactionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class InventoryTransactionController {

    private final InventoryTransactionService inventoryTransactionService;

    public InventoryTransactionController(InventoryTransactionService inventoryTransactionService) {
        this.inventoryTransactionService = inventoryTransactionService;
    }

    @PostMapping
    public InventoryTransactionResponse createTransaction(@Valid @RequestBody InventoryTransactionRequest request) {
        return inventoryTransactionService.createTransaction(request);
    }

    @GetMapping("/{id}")
    public InventoryTransactionResponse getTransactionById(@PathVariable Long id) {
        return inventoryTransactionService.getTransactionById(id);
    }

    @GetMapping
    public List<InventoryTransactionResponse> getAllTransactions() {
        return inventoryTransactionService.getAllTransactions();
    }

    @GetMapping("/products/{productId}")
    public List<InventoryTransactionResponse> getTransactionByProduct(@PathVariable Long productId) {
        return inventoryTransactionService.getTransactionsByProduct(productId);
    }

}

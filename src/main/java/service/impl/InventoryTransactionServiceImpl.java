package service.impl;

import com.cam.inventory_api.dto.InventoryTransactionRequest;
import com.cam.inventory_api.dto.InventoryTransactionResponse;
import com.cam.inventory_api.repository.InventoryTransactionRepository;
import com.cam.inventory_api.repository.ProductRepository;
import com.cam.inventory_api.repository.WarehouseRepository;
import org.springframework.stereotype.Service;
import service.InventoryTransactionService;

import java.util.List;

@Service
public class InventoryTransactionServiceImpl implements InventoryTransactionService {

    private ProductRepository productRepository;
    private WarehouseRepository warehouseRepository;
    private InventoryTransactionRepository inventoryTransactionRepository;

    public InventoryTransactionServiceImpl(ProductRepository productRepository, WarehouseRepository warehouseRepository, InventoryTransactionRepository inventoryTransactionRepository) {
        this.productRepository = productRepository;
        this.warehouseRepository = warehouseRepository;
        this.inventoryTransactionRepository = inventoryTransactionRepository;
    }

    @Override
    public InventoryTransactionResponse createTransaction(InventoryTransactionRequest request) {
        return null;
    }

    @Override
    public InventoryTransactionResponse getTransactionById(Long id) {
        return null;
    }

    @Override
    public List<InventoryTransactionResponse> getAllTransactions() {
        return List.of();
    }

    @Override
    public InventoryTransactionResponse updateTransaction(Long id, InventoryTransactionRequest request) {
        return null;
    }

    @Override
    public void deleteTransaction(Long id) {

    }
}

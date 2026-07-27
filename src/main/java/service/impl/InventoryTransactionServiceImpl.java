package service.impl;

import com.cam.inventory_api.dto.InventoryTransactionRequest;
import com.cam.inventory_api.dto.InventoryTransactionResponse;
import com.cam.inventory_api.entity.InventoryTransaction;
import com.cam.inventory_api.entity.Product;
import com.cam.inventory_api.entity.Warehouse;
import com.cam.inventory_api.enums.TransactionType;
import com.cam.inventory_api.repository.InventoryTransactionRepository;
import com.cam.inventory_api.repository.ProductRepository;
import com.cam.inventory_api.repository.WarehouseRepository;
import org.springframework.stereotype.Service;
import service.InventoryTransactionService;

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


        if (request.getTransactionType() == TransactionType.PURCHASE) {
            product.setCurrentStock(product.getCurrentStock() + request.getTransactionQuantity());
        } else if (request.getTransactionType() == TransactionType.SALE) {
            product.setCurrentStock(product.getCurrentStock() - request.getTransactionQuantity());
        } else if (request.getTransactionType() == TransactionType.RETURN) {
            product.setCurrentStock(product.getCurrentStock() + request.getTransactionQuantity());
        } else if (request.getTransactionType() == TransactionType.ADJUSTMENT) {
            product.setCurrentStock(request.getTransactionQuantity());
        }





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

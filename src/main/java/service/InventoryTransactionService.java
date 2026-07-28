package service;

import com.cam.inventory_api.dto.InventoryTransactionRequest;
import com.cam.inventory_api.dto.InventoryTransactionResponse;

import java.util.List;

public interface InventoryTransactionService {

    InventoryTransactionResponse createTransaction(InventoryTransactionRequest request);

    InventoryTransactionResponse getTransactionById(Long id);

    List<InventoryTransactionResponse> getAllTransactions();

    List<InventoryTransactionResponse> getTransactionsByProduct(Long productId);

}

package service;

import com.cam.inventory_api.dto.InventoryTransactionRequest;
import com.cam.inventory_api.dto.InventoryTransactionResponse;

import java.util.*;

public interface InventoryTransactionService {

    InventoryTransactionResponse createTransaction(InventoryTransactionRequest request);

    InventoryTransactionResponse getTransactionById(Long id);

    List<InventoryTransactionResponse> getAllTransactions();

    InventoryTransactionResponse updateTransaction(Long id,
                                                   InventoryTransactionRequest request);

    void deleteTransaction(Long id);

}

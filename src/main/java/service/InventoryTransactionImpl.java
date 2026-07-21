package service;

import com.cam.inventory_api.dto.InventoryTransactionRequest;
import com.cam.inventory_api.dto.InventoryTransactionResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryTransactionImpl implements InventoryTransactionService {

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

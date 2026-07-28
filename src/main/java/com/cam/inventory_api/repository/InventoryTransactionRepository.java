package com.cam.inventory_api.repository;

import com.cam.inventory_api.entity.InventoryTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryTransactionRepository extends JpaRepository<InventoryTransaction, Long> {
    List<InventoryTransaction> findByProductId(Long productId);

    Long id(Long id);

    Long id(Long id);
}

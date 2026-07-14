package com.cam.inventory_api.enums;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum TransactionType {
    
    PURCHASE,
    SALE,
    RETURN,
    ADJUSTMENT
}

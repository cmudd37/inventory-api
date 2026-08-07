package com.cam.inventory_api.service;

import com.cam.inventory_api.dto.WarehouseRequest;
import com.cam.inventory_api.dto.WarehouseResponse;

import java.util.List;

public interface WarehouseService {
    public WarehouseResponse createWarehouse(WarehouseRequest request);

    public List<WarehouseResponse> getAllWarehouses();

    public WarehouseResponse updateWarehouse(Long id, WarehouseRequest request);

    public void deleteWarehouseById(Long id);
}

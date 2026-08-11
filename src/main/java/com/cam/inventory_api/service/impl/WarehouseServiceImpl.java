package com.cam.inventory_api.service.impl;

import com.cam.inventory_api.dto.WarehouseRequest;
import com.cam.inventory_api.dto.WarehouseResponse;
import com.cam.inventory_api.entity.Warehouse;
import com.cam.inventory_api.service.WarehouseService;
import com.cam.inventory_api.repository.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    private final WarehouseRepository warehouseRepository;

    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public WarehouseResponse createWarehouse(WarehouseRequest request) {
        Warehouse warehouse = new Warehouse(
                request.getName(),
                request.getAddress(),
                request.getCapacity()
        );

        Warehouse savedWarehouse = warehouseRepository.save(warehouse);

        return mapToResponse(savedWarehouse);
    }

    @Override
    public WarehouseResponse getWarehouseById(Long id) {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Warehouse not found."));

        return mapToResponse(warehouse);
    }

    @Override
    public List<WarehouseResponse> getAllWarehouses() {
        return warehouseRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public WarehouseResponse updateWarehouse(Long id, WarehouseRequest request) {
        Warehouse existingWarehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Warehouse not found."));

        existingWarehouse.setName(request.getName());
        existingWarehouse.setAddress(request.getAddress());
        existingWarehouse.setCapacity(request.getCapacity());

        Warehouse savedWarehouse = warehouseRepository.save(existingWarehouse);

        return mapToResponse(savedWarehouse);
    }

    @Override
    public void deleteWarehouseById(Long id) {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Warehouse not found."));

        warehouseRepository.delete(warehouse);
    }

    private WarehouseResponse mapToResponse(Warehouse warehouse) {
        return new WarehouseResponse(
                warehouse.getId(),
                warehouse.getName(),
                warehouse.getAddress(),
                warehouse.getCapacity()
        );
    }
}
package com.cam.inventory_api.controller;

import com.cam.inventory_api.dto.WarehouseRequest;
import com.cam.inventory_api.dto.WarehouseResponse;
import com.cam.inventory_api.service.WarehouseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @PostMapping
    public WarehouseResponse createWarehouse(@Valid @RequestBody WarehouseRequest request) {
        return warehouseService.createWarehouse(request);
    }

    @GetMapping("/{id}")
    public WarehouseResponse getWarehouseById(@PathVariable Long id) {
        return warehouseService.getWarehouseById(id);
    }

    @GetMapping
    public List<WarehouseResponse> getAllWarehouses() {
        return warehouseService.getAllWarehouses();
    }

    @PutMapping("/{id}")
    public WarehouseResponse updateWarehouse(@PathVariable Long id, @Valid @RequestBody WarehouseRequest request) {
        return warehouseService.updateWarehouse(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteWarehouse(@PathVariable Long id) {
        warehouseService.deleteWarehouseById(id);
    }


}

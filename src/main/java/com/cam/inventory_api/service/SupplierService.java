package com.cam.inventory_api.service;

import com.cam.inventory_api.dto.SupplierRequest;
import com.cam.inventory_api.dto.SupplierResponse;

import java.util.List;

public interface SupplierService {

    public SupplierResponse createSupplier(SupplierRequest supplierRequest);

    public List<SupplierResponse> getAllSuppliers();

    public SupplierResponse updateSupplier(Long id, SupplierRequest supplierRequest);

    public void deleteSupplierById(Long id);
}

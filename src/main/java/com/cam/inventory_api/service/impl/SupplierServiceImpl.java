package com.cam.inventory_api.service.impl;

import com.cam.inventory_api.dto.SupplierRequest;
import com.cam.inventory_api.dto.SupplierResponse;
import com.cam.inventory_api.entity.Supplier;
import com.cam.inventory_api.repository.SupplierRepository;
import com.cam.inventory_api.service.SupplierService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }


    @Override
    public SupplierResponse createSupplier(SupplierRequest request) {
        Supplier supplier = new Supplier(
                request.getName(),
                request.getEmail(),
                request.getPhoneNumber()
        );

        Supplier savedSupplier = supplierRepository.save(supplier);

        return mapToResponse(savedSupplier);
    }

    @Override
    public SupplierResponse getSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found."));

        return mapToResponse(supplier);
    }

    @Override
    public List<SupplierResponse> getAllSuppliers() {
       return supplierRepository.findAll()
               .stream()
               .map(this::mapToResponse)
               .toList();
    }

    @Override
    public SupplierResponse updateSupplier(Long id, SupplierRequest request) {
        Supplier exisitingSupplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found."));

        exisitingSupplier.setCompanyName(request.getName());
        exisitingSupplier.setEmail(request.getEmail());
        exisitingSupplier.setPhoneNumber(request.getPhoneNumber());

        Supplier savedSupplier = supplierRepository.save(exisitingSupplier);

        return mapToResponse(savedSupplier);
    }

    @Override
    public void deleteSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found."));

        supplierRepository.delete(supplier);
    }

    private SupplierResponse mapToResponse(Supplier supplier) {
        return new SupplierResponse(
                supplier.getId(),
                supplier.getCompanyName(),
                supplier.getEmail(),
                supplier.getPhoneNumber()
        );
    }
}

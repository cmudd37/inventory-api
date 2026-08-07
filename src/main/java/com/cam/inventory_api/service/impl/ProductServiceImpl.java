package com.cam.inventory_api.service.impl;

import com.cam.inventory_api.dto.ProductRequest;
import com.cam.inventory_api.dto.ProductResponse;
import com.cam.inventory_api.entity.Category;
import com.cam.inventory_api.entity.Product;
import com.cam.inventory_api.entity.Supplier;
import com.cam.inventory_api.repository.CategoryRepository;
import com.cam.inventory_api.repository.ProductRepository;
import com.cam.inventory_api.repository.SupplierRepository;
import com.cam.inventory_api.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SupplierRepository supplierRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public ProductResponse createProduct(ProductRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Product not found."));

        Supplier supplier = supplierRepository.findById(request.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found."));

        Product product = new Product(
                request.getName(),
                request.getPrice(),
                request.getCurrentStock(),
                category,
                supplier
        );

        Product savedProduct = productRepository.save(product);

        return mapToResponse(savedProduct);
    }

    @Override
    public List<ProductResponse> getALLProducts() {
        return List.of();
    }

    @Override
    public ProductResponse getProductById(Long id) {
        return null;
    }

    @Override
    public ProductResponse updateProduct(Long id, Product updatedProduct) {
        return null;
    }

    @Override
    public ProductResponse deleteProductById(Long id) {
        return null;
    }

    public ProductResponse mapToResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getCategory().getId(),
                product.getCategory().getName(),
                product.getSupplier().getId(),
                product.getSupplier().getCompanyName(),
                product.getPrice(),
                product.getCurrentStock()
        );

    }
}

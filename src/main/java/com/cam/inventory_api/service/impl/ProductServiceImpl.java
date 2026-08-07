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
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return mapToResponse(product);
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product exisitingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found."));

        Category category = categoryRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Category not found."));

        Supplier supplier = supplierRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Supplier not found."));

        exisitingProduct.setName(request.getName());
        exisitingProduct.setPrice(request.getPrice());
        exisitingProduct.setCurrentStock(request.getCurrentStock());
        exisitingProduct.setCategory(category);
        exisitingProduct.setSupplier(supplier);

        Product savedProduct = productRepository.save(exisitingProduct);

        return mapToResponse(savedProduct);
    }

    @Override
    public void deleteProductById(Long id) {
        Product product = productRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Product not found."));

        productRepository.delete(product);
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

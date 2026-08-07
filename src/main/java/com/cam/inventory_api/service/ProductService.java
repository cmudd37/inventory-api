package com.cam.inventory_api.service;

import com.cam.inventory_api.dto.ProductRequest;
import com.cam.inventory_api.dto.ProductResponse;
import com.cam.inventory_api.entity.Product;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductRequest request);

    List<ProductResponse> getALLProducts();

    ProductResponse getProductById(Long id);

    ProductResponse updateProduct(Long id, Product updatedProduct);

    void deleteProductById(Long id);
}

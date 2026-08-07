package com.cam.inventory_api.service;

import com.cam.inventory_api.dto.ProductRequest;
import com.cam.inventory_api.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductRequest request);

    List<ProductResponse> getAllProducts();

    ProductResponse getProductById(Long id);

    ProductResponse updateProduct(Long id, ProductRequest request);

    void deleteProductById(Long id);
}

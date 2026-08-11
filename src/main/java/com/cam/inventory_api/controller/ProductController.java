package com.cam.inventory_api.controller;

import com.cam.inventory_api.dto.ProductRequest;
import com.cam.inventory_api.dto.ProductResponse;
import com.cam.inventory_api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductResponse createProduct(@Valid @RequestBody ProductRequest request) {
        return productService.createProduct(request);
    }

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable Long id, @PathVariable ProductRequest request) {
        return productService.updateProduct(id, request);
    }

    @DeleteMapping
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

}

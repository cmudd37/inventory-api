package com.cam.inventory_api.controller;


import com.cam.inventory_api.dto.CategoryRequest;
import com.cam.inventory_api.dto.CategoryResponse;
import com.cam.inventory_api.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
     private final CategoryService categoryService;

     public CategoryController(CategoryService categoryService) {
         this.categoryService = categoryService;
     }

     @PostMapping
     public CategoryResponse createCategory(@Valid @RequestBody CategoryRequest request) {
         return categoryService.createCategory(request);
     }

     @GetMapping
     public List<CategoryResponse> getAllCategories() {
         return categoryService.getAllCategories();
     }

     @GetMapping("/{id}")
     public CategoryResponse getCategoryById(@PathVariable Long id) {
         return categoryService.getCategoryById(id);
     }

     @PutMapping("/{id}")
     public CategoryResponse updateCategory(@PathVariable Long id, @RequestBody CategoryRequest request) {
         return categoryService.updateCategory(id, request);
     }

     @DeleteMapping("/{id}")
     public void deleteCategory(@PathVariable Long id) {
         categoryService.deleteCategoryById(id);
     }

}
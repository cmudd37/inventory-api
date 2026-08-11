package com.cam.inventory_api.service;

import com.cam.inventory_api.dto.CategoryRequest;
import com.cam.inventory_api.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {
    public CategoryResponse createCategory(CategoryRequest request);

    public CategoryResponse getCategoryById(Long id);

    public List<CategoryResponse> getAllCategories();

    public CategoryResponse updateCategory(Long id, CategoryRequest request);

    public void deleteCategoryById(Long id);
}

package com.example.assignment3.service;

import com.example.assignment3.dto.CategoryDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CategoryService {
    public List<CategoryDto> getCategories();
    public String addCategory(CategoryDto categoryDto);
    public String deleteCategory(int categoryId);
    public String updateCategory(int categoryId, CategoryDto categoryDto);
}

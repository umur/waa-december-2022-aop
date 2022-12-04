package com.example.assignment3.controller;

import com.example.assignment3.dto.CategoryDto;
import com.example.assignment3.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {
    private CategoryService categoryService;
    CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ResponseBody
    @GetMapping("/categories")
    public List<CategoryDto> getCategories() {
        return categoryService.getCategories();
    }

    @ResponseBody
    @PostMapping("/categories")
    public String addCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.addCategory(categoryDto);
    }

    @ResponseBody
    @DeleteMapping("/categories/{categoryId}")
    public String deleteCategory(@PathVariable int categoryId) {
        return categoryService.deleteCategory(categoryId);
    }

    @ResponseBody
    @PutMapping("/categories/{categoryId}")
    public String updateCategory(@PathVariable int categoryId, @RequestBody CategoryDto categoryDto) {
        return categoryService.updateCategory(categoryId, categoryDto);
    }
}

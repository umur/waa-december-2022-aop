package com.example.assignment3.service.impl;

import com.example.assignment3.aspect.annotation.ExecutionTime;
import com.example.assignment3.aspect.annotation.Logger;
import com.example.assignment3.dto.CategoryDto;
import com.example.assignment3.entity.Category;
import com.example.assignment3.repo.CategoryRepo;
import com.example.assignment3.service.CategoryService;
import com.example.assignment3.service.UtilityService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepo categoryRepo;
    private ModelMapper modelMapper;
    private UtilityService utilityService;
    public CategoryServiceImpl(CategoryRepo categoryRepo, ModelMapper modelMapper, UtilityService utilityService) {
        this.categoryRepo = categoryRepo;
        this.modelMapper = modelMapper;
        this.utilityService =  utilityService;
    }

    @ExecutionTime
    @Logger
    @Override
    public List<CategoryDto> getCategories() {
        List<CategoryDto> categories = new ArrayList<>();
        Iterable<Category> categoryIterable = categoryRepo.findAll();
        for(Category category: categoryIterable) {
            categories.add(modelMapper.map(category, CategoryDto.class));
        }
        return categories;
    }

    @Override
    public String addCategory(CategoryDto categoryDto) {
        try {
            categoryDto.setId(utilityService.getRandomNumber());
            categoryRepo.save(modelMapper.map(categoryDto, Category.class));
            return "Category added successfully!";
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String deleteCategory(int categoryId) {
        try {
            categoryRepo.deleteById(categoryId);
            return "Category deleted successfully!";
        } catch(Exception e) {
            throw e;
        }
    }

    @Override
    public String updateCategory(int categoryId, CategoryDto categoryDto) {
        try {
            categoryDto.setId(categoryId);
            categoryRepo.save(modelMapper.map(categoryDto, Category.class));
            return "Category updated successfully!";
        } catch (Exception e) {
            throw e;
        }
    }
}

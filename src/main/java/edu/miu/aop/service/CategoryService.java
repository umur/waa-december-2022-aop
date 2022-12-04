package edu.miu.aop.service;

import edu.miu.aop.dto.CategoryDto;
import edu.miu.aop.dto.CategoryDto;

public interface CategoryService {
    Iterable<CategoryDto> getAll();
    CategoryDto getById(int id);
    void save(CategoryDto category);
    void update(int id, CategoryDto category);
    void delete(int id);
}


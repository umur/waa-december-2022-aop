package com.example.AOP.Service;

import com.example.AOP.Entity.Category;
import com.example.AOP.Entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    void save(Category category);

    void delete(int categoryId);

    Category getById(int categoryId);

    List<Category> getAll();

    List<Product>  findAllByCategoryAndPriceLessThan(Category category,int maxPrice);
}

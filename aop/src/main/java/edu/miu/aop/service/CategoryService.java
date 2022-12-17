package edu.miu.aop.service;

import edu.miu.aop.entity.Category;
import edu.miu.aop.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    void save(Category category);

    void delete(Long categoryId);

    Category getById(Long categoryId);

    List<Category> getAll();

    List<Product> findAllByCategoryAndPriceLessThan(Category cat, double maxPrice);

}

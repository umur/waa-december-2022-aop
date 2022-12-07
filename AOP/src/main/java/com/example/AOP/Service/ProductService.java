package com.example.AOP.Service;

import com.example.AOP.Entity.Product;
import com.example.AOP.Entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    void save(Product product);

    void delete(int productId);

    Product getById(int productId);

    List<Product> getAll();

    List<Product> findAllByPriceGreaterThan(int minPrice);

    List<Product> findAllByNameContaining(String name);

    List<Review> findReviewByProductId(int productId);

}

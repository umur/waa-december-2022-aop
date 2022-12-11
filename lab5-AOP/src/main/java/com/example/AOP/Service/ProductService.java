package com.example.AOP.Service;

import com.example.AOP.Entity.Product;
import com.example.AOP.Entity.Review;

import java.util.List;


public interface ProductService {
    public Product save(Product product);
    public void delete(int id);
    public Product get(int id);
    public List<Product> getAll();

    List<Product> findProductGreaterThanMinPrice(Double minPrice);
    List<Product> findByName(String name);
    List<Review> findReviewById(int id);

}
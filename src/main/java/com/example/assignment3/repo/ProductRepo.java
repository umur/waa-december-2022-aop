package com.example.assignment3.repo;

import com.example.assignment3.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
    public List<Product> findByPriceGreaterThan(float minPrice);
    public List<Product> findAllByCategory_NameAndPriceLessThan(String cat, float minPrice);
    public List<Product> findAllByNameContainingIgnoreCase(String keyword);
}

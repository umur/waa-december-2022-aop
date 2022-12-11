package com.example.AOP.Service.ServiceImpl;

import com.example.AOP.Entity.Product;
import com.example.AOP.Entity.Review;
import com.example.AOP.Repository.ProductRepo;
import com.example.AOP.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductImpl implements ProductService {

    @Autowired

    private ProductRepo repo;
    public Product save(Product product) {
     return repo.save(product);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);

    }

    @Override
    public Product get(int id) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        var rev = new ArrayList<Product>();
        repo.findAll().forEach(rev::add);
        return  rev;
    }

    @Override
    public List<Product> findProductGreaterThanMinPrice(Double minPrice) {
        var prod = repo.findByPriceGreaterThan(minPrice);
        return  prod;
    }

    @Override
    public List<Product> findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public List<Review> findReviewById(int id) {
        return null;
    }
}

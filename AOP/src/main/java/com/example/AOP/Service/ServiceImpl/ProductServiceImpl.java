package com.example.AOP.Service.ServiceImpl;

import com.example.AOP.Entity.Product;
import com.example.AOP.Entity.Review;
import com.example.AOP.Repository.ProductRepo;
import com.example.AOP.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    @Override
    public void save(Product product) {
       productRepo.save(product);
    }

    @Override
    public void delete(int productId) {
       productRepo.deleteById(productId);
    }

    @Override
    public Product getById(int productId) {
        return productRepo.findById(productId).get();
    }

    @Override
    public List<Product> getAll() {
        var productList = new ArrayList<Product>();
        productRepo.findAll().forEach(productList::add);
        return productList;
    }

    @Override
    public List<Product> findAllByPriceGreaterThan(int minPrice) {
        return productRepo.findAllByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> findAllByNameContaining(String name) {
        return productRepo.findAllByNameContaining(name);
    }

    @Override
    public List<Review> findReviewByProductId(int productId) {
        return productRepo.findById(productId).get().getReview();
    }
}

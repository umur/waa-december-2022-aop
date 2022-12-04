package com.example.assignment3.service;

import com.example.assignment3.dto.ProductDto;
import com.example.assignment3.entity.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductService {
    public List<ProductDto> getProducts();
    public String addProduct(ProductDto productDto);
    public String deleteProduct(int productId);
    public String updateProduct(int productId, ProductDto productDto);
    public List<ProductDto> getProductsByMinPrice(float minPrice);
    public List<ProductDto> findAllByCategoryAndPriceLessThan(String cat, float maxPrice);
    public List<ProductDto> findAllByNameContains(String keyword);
}

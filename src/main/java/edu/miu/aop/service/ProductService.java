package edu.miu.aop.service;

import edu.miu.aop.dto.ProductDto;
import edu.miu.aop.dto.ReviewDto;

public interface ProductService {
    Iterable<ProductDto> getAll();
    ProductDto getById(int id);
    void save(ProductDto product);
    void update(int id, ProductDto product);
    void delete(int id);

    Iterable<ReviewDto> getReviewsById(int id);

    Iterable<ProductDto> findAllByPriceGreaterThan(double minPrice);

    Iterable<ProductDto> findAllByCategoryAndPriceLessThan(String cat, double maxPrice);

    Iterable<ProductDto> findAllByNameContainingIgnoreCase(String name);
}


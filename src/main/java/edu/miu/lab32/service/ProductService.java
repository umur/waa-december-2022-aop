package edu.miu.lab32.service;

import edu.miu.lab32.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    // Find all products that cost more than `minPrice`.
    List<ProductDTO> findProductsByPrice(double minPrice);

    List<ProductDTO> findProductsByCategory_NameAndPriceLessThan(String category_name, double price);

    List<ProductDTO> findAllByNameContaining(String filterText);

    ProductDTO getProductById(int id);

    void addProduct(ProductDTO productDTO);
}
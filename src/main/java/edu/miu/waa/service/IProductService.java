package edu.miu.waa.service;

import java.util.List;

import edu.miu.waa.model.dto.ProductDTO;

public interface IProductService {
    // Find all products that cost more than `minPrice`.
    List<ProductDTO> findProductsByPrice(double minPrice);

    List<ProductDTO> findProductsByCategory_NameAndPriceLessThan(String category_name, double price);

    List<ProductDTO> findAllByNameContaining(String filterText);

    ProductDTO getProductById(int id);

    void addProduct(ProductDTO productDTO);
}

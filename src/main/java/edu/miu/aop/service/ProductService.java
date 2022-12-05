package edu.miu.aop.service;

import edu.miu.aop.dto.ProductDto;
import edu.miu.aop.entity.Category;
import edu.miu.aop.entity.Product;

import java.util.List;

/**
 * @author Ankhbayar Azzaya
 */
public interface ProductService {

    List<ProductDto> findAll();
    ProductDto findById(int id);
    void deleteById(int id);
    void update(int id, ProductDto productDto);
    void save(ProductDto productDto);

    List<ProductDto> findAllByPriceGreaterThan(int price);
    List<ProductDto> findAllByCategory_IdAndPriceIsLessThan(int categoryId, int price);
    List<ProductDto> findAllByNameContaining(String keyword);

}

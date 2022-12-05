package miu.edu.springaop.service;


import miu.edu.springaop.dto.AddressDto;
import miu.edu.springaop.dto.ProductDto;
import miu.edu.springaop.entity.Product;

import java.util.List;

public interface ProductService{
    ProductDto save(ProductDto product);
    void deleteById(int id);
    ProductDto update(ProductDto p);
    ProductDto getById(int id);
    List<ProductDto> getAllProducts();

    List<ProductDto> getByMinPrice(double price);
    List<ProductDto> getByMaxPriceAndCat(double price, int categoryId);
    List<ProductDto> getByName(String keyword);

}

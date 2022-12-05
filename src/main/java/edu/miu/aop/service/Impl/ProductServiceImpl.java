package edu.miu.aop.service.Impl;

import edu.miu.aop.dto.ProductDto;
import edu.miu.aop.entity.Category;
import edu.miu.aop.entity.Product;
import edu.miu.aop.repository.ProductRepo;
import edu.miu.aop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ankhbayar Azzaya
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ModelMapper mapper;

    @Override
    public List<ProductDto> findAll() {
        List<ProductDto> productDtos = new ArrayList<>();
        productRepo.findAll().forEach(p -> {
            if (!p.isDeleted())
                productDtos.add(mapper.map(p, ProductDto.class));
        });
        return productDtos;
    }

    @Override
    public ProductDto findById(int id) {
        Product product = productRepo.findById(id).get();
        if (product.isDeleted()) return null;
        return mapper.map(product, ProductDto.class);
    }

    @Override
    public void deleteById(int id) {
        Product product = productRepo.findById(id).get();
        product.setDeleted(true);
        productRepo.save(product);
        //productRepo.deleteById(id);
    }

    @Override
    public void update(int id, ProductDto productDto) {
        productRepo.save(mapper.map(productDto, Product.class));
    }

    @Override
    public void save(ProductDto productDto) {
        productRepo.save(mapper.map(productDto, Product.class));
    }

    @Override
    public List<ProductDto> findAllByPriceGreaterThan(int price) {
        return productRepo.findAllByPriceGreaterThan(price)
                .stream()
                .map(product -> mapper.map(product, ProductDto.class))
                .toList();
    }

    @Override
    public List<ProductDto> findAllByCategory_IdAndPriceIsLessThan(int categoryId, int price) {
        return productRepo.findAllByCategory_IdAndPriceIsLessThan(categoryId, price)
                .stream()
                .map(product -> mapper.map(product, ProductDto.class))
                .toList();
    }

    @Override
    public List<ProductDto> findAllByNameContaining(String keyword) {
        return productRepo.findAllByNameContaining(keyword)
                .stream()
                .map(product -> mapper.map(product, ProductDto.class))
                .toList();
    }
}

package com.example.assignment3.service.impl;

import com.example.assignment3.aspect.annotation.ExecutionTime;
import com.example.assignment3.aspect.annotation.Logger;
import com.example.assignment3.dto.ProductDto;
import com.example.assignment3.entity.Product;
import com.example.assignment3.repo.ProductRepo;
import com.example.assignment3.service.ProductService;
import com.example.assignment3.service.UtilityService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepo productRepo;
    private ModelMapper modelMapper;
    private UtilityService utils;
    public ProductServiceImpl(ProductRepo productRepo, ModelMapper modelMapper, UtilityService utils) {
        this.productRepo = productRepo;
        this.modelMapper = modelMapper;
        this.utils = utils;
    }

    @ExecutionTime
    @Logger
    @Override
    public List<ProductDto> getProducts() {
        List<ProductDto> products = new ArrayList<>();
        Iterable<Product> productList = productRepo.findAll();
        for (Product product : productList) {
            products.add(modelMapper.map(product, ProductDto.class));
        }
        return products;
    }

    @Override
    public String addProduct(ProductDto productDto) {
        try {
            productDto.setId(utils.getRandomNumber());
            productRepo.save(modelMapper.map(productDto, Product.class));
            return "Product Added successfully!";
        }catch (Exception e) {
            throw  e;
        }
    }

    @Override
    public String deleteProduct(int productId) {
        try {
            productRepo.deleteById(productId);
            return "Product Deleted successfully!";
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String updateProduct(int productId, ProductDto productDto) {
        try {
            productDto.setId(productId);
            productRepo.save(modelMapper.map(productDto, Product.class));
            return "Product updated successfully!";
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<ProductDto> getProductsByMinPrice(float minPrice) {
        return productRepo.findByPriceGreaterThan(minPrice).stream()
                .map(product -> modelMapper.map(product,ProductDto.class))
                .toList();
    }

    @Override
    public List<ProductDto> findAllByCategoryAndPriceLessThan(String cat, float maxPrice) {
        return productRepo.findAllByCategory_NameAndPriceLessThan(cat, maxPrice).stream()
                .map(product -> modelMapper.map(product,ProductDto.class))
                .toList();
    }

    @Override
    public List<ProductDto> findAllByNameContains(String keyword) {
        return  productRepo.findAllByNameContainingIgnoreCase(keyword).stream()
                .map(product -> modelMapper.map(product,ProductDto.class))
                .toList();
    }
}

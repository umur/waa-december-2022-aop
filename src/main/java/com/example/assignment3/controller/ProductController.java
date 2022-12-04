package com.example.assignment3.controller;

import com.example.assignment3.dto.ProductDto;
import com.example.assignment3.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.getProducts();
    }


    @PostMapping
    public String addProduct(@RequestBody ProductDto productDto) {
        return productService.addProduct(productDto);
    }


    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        return productService.deleteProduct(productId);
    }


    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable int productId, @RequestBody ProductDto productDto) {
        return productService.updateProduct(productId, productDto);
    }


    @GetMapping("/getByMinPrice")
    public List<ProductDto> getProductsByMinPrice(@RequestParam float minPrice) {
        return productService.getProductsByMinPrice(minPrice);
    }


    @GetMapping("/getByMaxPrice")
    public List<ProductDto> getProductsLessThanMaxPrice(@RequestParam String cat, @RequestParam float maxPrice) {
        return productService.findAllByCategoryAndPriceLessThan(cat, maxPrice);
    }

    @GetMapping("/getByKeyword")
    public List<ProductDto> findAllByNameContains(@RequestParam String keyword) {
        return productService.findAllByNameContains(keyword);
    }
}

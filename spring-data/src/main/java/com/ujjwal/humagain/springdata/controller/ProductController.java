package com.ujjwal.humagain.springdata.controller;

import com.ujjwal.humagain.springdata.entity.Product;
import com.ujjwal.humagain.springdata.entity.Review;
import com.ujjwal.humagain.springdata.entity.dto.ProductDto;
import com.ujjwal.humagain.springdata.entity.dto.ReviewDto;
import com.ujjwal.humagain.springdata.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable int id) {
        return productService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody ProductDto productDto){
        productService.save(productDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody ProductDto productDto) {
        productService.update(id, productDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }

    @GetMapping("/filterByPriceGreaterThan")
    public List<Product> findAllByPriceGreaterThan(@RequestParam int minPrice){
        return productService.findAllByPriceGreaterThan(minPrice);
    }
    @GetMapping("/filterByName")
    public List<Product> findAllByNameContaining(@RequestParam String keyword){
        return productService.findAllByNameContaining(keyword);
    }
    @GetMapping("/filterByCategoryAndPriceLessThan")
    public List<Product> findAllByCategory_NameAndPriceLessThan(@RequestParam String name, @RequestParam int maxPrice){
        return productService.findAllByCategory_NameAndPriceLessThan(name,maxPrice);
    }

    @GetMapping("/{id}/reviews")
    public List<Review> findAllByProductId(@PathVariable int id){
        return productService.findAllByProductId(id);
    }
}

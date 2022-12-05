package edu.miu.aop.controller;

import edu.miu.aop.aspect.annotation.ExecutionTime;
import edu.miu.aop.dto.ProductDto;
import edu.miu.aop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ankhbayar Azzaya
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @ExecutionTime
    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @ExecutionTime
    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable int id) {
        return productService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody ProductDto productDto) {
        productService.save(productDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody ProductDto productDto) {
        productService.save(productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        productService.deleteById(id);
    }

    @ExecutionTime
    @GetMapping("/findAllByPriceGreaterThan")
    public List<ProductDto> findAllByPriceGreaterThan(@RequestParam int price) {
        return productService.findAllByPriceGreaterThan(price);
    }

    @ExecutionTime
    @GetMapping("/findAllByCategory_IdAndPriceIsLessThan")
    public List<ProductDto> findAllByCategory_IdAndPriceIsLessThan(@RequestParam int categoryId, @RequestParam int price) {
        return productService.findAllByCategory_IdAndPriceIsLessThan(categoryId, price);
    }

    @ExecutionTime
    @GetMapping("/findAllByNameContaining")
    public List<ProductDto> findAllByNameContaining(@RequestParam String keyword) {
        return productService.findAllByNameContaining(keyword);
    }
}



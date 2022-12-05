package miu.edu.springaop.controller;

import miu.edu.springaop.aspect.annotation.ExecutionTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import miu.edu.springaop.dto.ProductDto;
import miu.edu.springaop.entity.Product;
import miu.edu.springaop.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ExecutionTime
    @GetMapping
    public List<ProductDto> getAll(){
        System.out.printf("getAll %n");

        return productService.getAllProducts();
    }
    @PostMapping
    public ProductDto save(@RequestBody ProductDto p){
            return productService.save(p);
    }

    @ExecutionTime
    @GetMapping("/{id}")
    public ProductDto getOne(@PathVariable int id){
        System.out.printf("getOne %s%n", id);
        return productService.getById(id);
    }

    @ExecutionTime
    @GetMapping("/filterByMinPrice")
    public List<ProductDto> getByMinPrice(@RequestParam double minPrice){
        System.out.printf("getByMinPrice %s%n", minPrice);

        return productService.getByMinPrice(minPrice);
    }

    @ExecutionTime
    @GetMapping("/filterByMaxPriceAndCategory")
    public List<ProductDto> getByMaxPriceAndCat(@RequestParam double maxPrice, @RequestParam int categoryId){
        System.out.printf("getByMaxPriceAndCat %s%n", categoryId);

        return productService.getByMaxPriceAndCat(maxPrice, categoryId);
    }

    @ExecutionTime
    @GetMapping("/filterByName")
    public List<ProductDto> getByName(@RequestParam String keyword){
        System.out.printf("getByName %s%n", keyword);

        return productService.getByName(keyword);
    }

    @ExecutionTime
    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable int id){
        System.out.printf("deleteOne %s%n", id);

        productService.deleteById(id);
    }

    @ExecutionTime
    @PutMapping("/{id}")
    public ProductDto updateOne(@RequestBody ProductDto p){
        System.out.printf("update %s%n", p);

        return productService.update(p);
    }

}

package edu.miu.lab32.controller;

import edu.miu.lab32.annotation.ExecutionTime;
import edu.miu.lab32.model.dto.ProductDTO;
import edu.miu.lab32.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/filterByPrice")
    @ExecutionTime
    public List<ProductDTO> getProductsByPriceMoreThan(@RequestParam double minPrice){
        return productService.findProductsByPrice(minPrice);
    }

    @GetMapping("/filterByCategoryAndPrice")
    public List<ProductDTO> getProductsByPriceMoreThan(@RequestParam String category, @RequestParam double price){
        return productService.findProductsByCategory_NameAndPriceLessThan(category, price);
    }

    @GetMapping("/filterByName")
    public List<ProductDTO> getProductsByNameContaining(@RequestParam String name){
        return productService.findAllByNameContaining(name);
    }

    @PostMapping //(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addProduct(@RequestBody ProductDTO productDTO){
        productService.addProduct(productDTO);
    }

}

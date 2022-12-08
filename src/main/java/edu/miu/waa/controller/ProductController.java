package edu.miu.waa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.waa.annotations.ExecutionTime;
import edu.miu.waa.model.dto.ProductDTO;
import edu.miu.waa.service.IProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
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

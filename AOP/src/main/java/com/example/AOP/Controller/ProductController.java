package com.example.AOP.Controller;
import com.example.AOP.Entity.Product;
import com.example.AOP.Entity.Review;
import com.example.AOP.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/lab3/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public String create(@RequestBody Product product) {
        try {
            productService.save(product);

            return "Product saved successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while saving Product.";
        }
    }

    @PutMapping
    public String update(@RequestBody Product product) {
        try {
            productService.save(product);

            return "Product updated successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while updating Product.";
        }
    }

    @DeleteMapping("/{productId}")
    public String delete(@PathVariable int productId) {
        try {
            productService.delete(productId);

            return "Product deleted successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while deleting Product.";
        }
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    public Product getById(@PathVariable int productId) {
        return productService.getById(productId);
    }

    @GetMapping("/filterByPriceGreaterThanMinPrice")
    public List<Product> filterAllByPriceGreaterThan(@RequestParam int minPrice) {
        return productService.findAllByPriceGreaterThan(minPrice);
    }

    @GetMapping("/filterByNameContaining")
    public List<Product> filterAllByNameContaining(@RequestParam String name) {
        return productService.findAllByNameContaining(name);
    }

    @GetMapping("/filterReviewByProductId")
    public List<Review> filterReviewByProductId(@RequestParam int productId) {
        return productService.findReviewByProductId(productId);
    }

}

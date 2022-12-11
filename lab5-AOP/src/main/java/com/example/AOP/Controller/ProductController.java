package com.example.AOP.Controller;

import com.example.AOP.Entity.Product;
import com.example.AOP.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/products")
@RestController
public class ProductController {
    @Autowired
    private  ProductService prod;
    @PostMapping()
    public Product addProduct(@RequestBody Product product){
        return prod.save(product);
    }
}


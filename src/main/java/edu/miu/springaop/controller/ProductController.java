package edu.miu.springaop.controller;

import edu.miu.springaop.aspect.annotation.ExecutionTime;
import edu.miu.springaop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @ExecutionTime
    @GetMapping
    public String getAll() {


       // System.out.println("method name : getAll");
        System.out.println("method get all");
        productService.testService();
        return "data data";
    }


    @ExecutionTime
    public void test1(){
    }

    @ExecutionTime
    public void test2(){
    }


    @PostMapping
    public String save() {

        System.out.println("before the function testService");
        productService.testService();
        return "save";
    }

    @DeleteMapping
    public void delete() {
       // System.out.println("method name : delete");
    }

}

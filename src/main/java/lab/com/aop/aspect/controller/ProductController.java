package lab.com.aop.aspect.controller;

import lab.com.aop.aspect.annotation.ExecutionTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @ExecutionTime
    @GetMapping
    public void getAll(){

    }
}

package edu.miu.service;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class Service {
    @PostMapping
    public void testMethod() {
        System.out.println("test");
    }


}

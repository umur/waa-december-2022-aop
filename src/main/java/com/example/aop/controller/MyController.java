package com.example.aop.controller;

import com.example.aop.aspect.annotation.ExecutionTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class MyController {
    @ExecutionTime
    @GetMapping
    public void CReateActivity() {
        System.out.println("activity");
    }
}

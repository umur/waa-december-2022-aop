package edu.miu.controller;

import edu.miu.aspect.annotations.ExecutionTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/")
public class controller {

//    private final Service service;

    @ExecutionTime
    @GetMapping
    public String testMethod(){
        return "test";
    }

}

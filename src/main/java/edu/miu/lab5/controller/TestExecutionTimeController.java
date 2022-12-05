package edu.miu.lab5.controller;

import edu.miu.lab5.annotation.ExecutionTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tests")
public class TestExecutionTimeController {

    @GetMapping
    @ExecutionTime
    public String test(){
        return "Hi";
    }

    @PostMapping
    public void addTest(){}
}

package com.example.aoplab5.Controller;

import com.example.aoplab5.Annotation.ExecutionTime;
import com.example.aoplab5.Entity.Student;
import com.example.aoplab5.Service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private StudentService stu;
    @GetMapping
    @ExecutionTime
    public List<Student> getAllStudent(){
        return stu.getAllStudents();
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){

        System.out.println("inside the add request..");
    }

    @GetMapping("/alert")
    public String alert(){
        return "Hey AOP.";
    }



}

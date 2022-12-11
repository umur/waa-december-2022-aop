package com.example.aoplab5.Serviceimpl;

import com.example.aoplab5.Entity.Student;
import com.example.aoplab5.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        Student eudis = new Student(1L, "Eudis Muhangi", "eudis@miu.edu", "34","Compro");
        Student alex = new Student(1L, "Alex wahn", "alex@gmail.com", "21","MSCD");
        students.add(eudis);
        students.add(alex);
        return students;
    }
}
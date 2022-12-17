package edu.miu.lab32.model.studentcourse;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Course {
    @Id
    private int id;
    private String courseCode;

    @OneToMany(mappedBy = "course")
    List<StudentsCourses> coursesTaken;
}
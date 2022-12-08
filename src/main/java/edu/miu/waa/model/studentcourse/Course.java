package edu.miu.waa.model.studentcourse;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Course {
    @Id
    private int id;
    private String courseCode;

    @OneToMany(mappedBy = "course")
    List<StudentsCourses> coursesTaken;
}

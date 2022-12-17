package edu.miu.lab32.model.studentcourse;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Student {

    @Id
    private int id;
    private String fName;
    private String lName;
    private String major;

    @OneToMany(mappedBy = "student")
    List<StudentsCourses> coursesTaken;
}

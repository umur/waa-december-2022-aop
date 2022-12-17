package edu.miu.lab32.model.studentcourse;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class StudentCoursesId implements Serializable {
    private String studentId;
    private String courseId;
}

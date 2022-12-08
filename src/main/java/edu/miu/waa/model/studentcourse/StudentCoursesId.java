package edu.miu.waa.model.studentcourse;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class StudentCoursesId implements Serializable {
    private String studentId;
    private String courseId;
}

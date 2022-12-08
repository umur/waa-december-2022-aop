package edu.miu.waa.model.studentcourse;

import java.util.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;

@Data
@Entity
public class StudentsCourses {

    @EmbeddedId
    private StudentCoursesId id;
    private Date courseTakenDate;
    private String assignedRoom;

    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    private Course course;
}

package miu.edu.lab5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Data
public class ActivityLog {

    @Id
    private long id;
    private LocalDate date;
    private String operation;
    private long duration;
}

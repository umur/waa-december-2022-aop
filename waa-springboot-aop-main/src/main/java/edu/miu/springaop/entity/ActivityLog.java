package edu.miu.springaop.entity;

import edu.miu.springaop.aspect.annotation.ExecutionTime;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate date;
    private String operation;
    private long duration;
    public ActivityLog(LocalDate date, String operation, long duration) {
        this.date = date;
        this.operation = operation;
        this.duration = duration;
    }
}



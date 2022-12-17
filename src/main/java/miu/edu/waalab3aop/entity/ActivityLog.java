package miu.edu.waalab3aop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Data
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate date;
    private String operation;
    private long duration;

    public ActivityLog(LocalDate date, String operation, long duration){
        this.date = date;
        this.operation = operation;
        this.duration = duration;
    }
}

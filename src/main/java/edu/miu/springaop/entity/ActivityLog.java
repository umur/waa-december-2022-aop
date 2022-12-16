package edu.miu.springaop.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDateTime date;
    private String operation;
    private Long duration;

    public ActivityLog(LocalDateTime date, String operation, Long duration) {
        this.date = date;
        this.operation = operation;
        this.duration = duration;
    }
}

package miu.edu.springaop.entity;

import jakarta.persistence.Embeddable;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.LocalDateTime;

@Embeddable
public class AuditFields {

    private LocalDateTime createDt;
    private LocalDateTime updateDt;

}

package miu.edu.springaop.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import miu.edu.springaop.entity.AuditFields;

import java.time.LocalDateTime;


@Getter
@Setter
public class AuditFieldsDto {
    private LocalDateTime createDt;
    private LocalDateTime updateDt;
}

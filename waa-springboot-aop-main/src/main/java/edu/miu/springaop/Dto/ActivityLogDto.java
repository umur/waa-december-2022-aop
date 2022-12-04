package edu.miu.springaop.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ActivityLogDto {
    //private int id;
    private LocalDate date;
    private String operation;
    private long duration;
}

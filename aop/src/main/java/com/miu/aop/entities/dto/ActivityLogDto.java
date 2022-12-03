package com.miu.aop.entities.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ActivityLogDto {
    private int id;
    private LocalDate date;
    private String operation;
    private long duration;
}

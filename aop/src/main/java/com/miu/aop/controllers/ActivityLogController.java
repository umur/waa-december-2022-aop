package com.miu.aop.controllers;

import com.miu.aop.entities.dto.ActivityLogDto;
import com.miu.aop.services.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/activity-logs")
public class ActivityLogController {
    public final ActivityLogService activityLogService;

    @GetMapping
    public List<ActivityLogDto> getAll(){
        return activityLogService.getAll();
    }
    @GetMapping("/{id}")
    public ActivityLogDto getById(@PathVariable int id){
        return activityLogService.getById(id);
    }
    @PostMapping
    public ActivityLogDto save(@RequestBody ActivityLogDto activityLogDto){
        return activityLogService.save(activityLogDto);
    }
}

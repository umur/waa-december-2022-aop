package edu.miu.springaop.controller;

import edu.miu.springaop.Dto.ActivityLogDto;
import edu.miu.springaop.Service.ActivityLogService;
import edu.miu.springaop.aspect.annotation.ExecutionTime;
import edu.miu.springaop.entity.ActivityLog;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/activitylogs")
@RequiredArgsConstructor
public class ActivityLogController {
    private final ActivityLogService activityLogService;

    @ExecutionTime
    @GetMapping
    public List<ActivityLogDto> getAll(){
        return activityLogService.getAll();
    }
    @ExecutionTime
   @GetMapping("/{id}")
    public ActivityLogDto getById(@PathVariable int id){
        return activityLogService.getById(id);
    }
   @ExecutionTime
      @PostMapping
      public ActivityLogDto save(@RequestBody ActivityLogDto activityLogDto){
         return activityLogService.save(activityLogDto);
       }
}

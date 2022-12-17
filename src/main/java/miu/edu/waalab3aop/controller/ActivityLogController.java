package miu.edu.waalab3aop.controller;

import miu.edu.waalab3aop.annotation.ExecutionTime;
import miu.edu.waalab3aop.entity.Activity;
import miu.edu.waalab3aop.entity.ActivityLog;
import miu.edu.waalab3aop.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityLogController {
    @Autowired
    private ActivityService activityService;

    @ExecutionTime
    @PostMapping("/activity")
    public Activity addActivityLog(@RequestHeader(name = "AOP-IS-AWESOME") String headerPersist, Activity activity) {
       return  activityService.addActivity(activity);
    }
}

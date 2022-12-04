package com.example.assignment3.service.impl;

import com.example.assignment3.entity.ActivityLog;
import com.example.assignment3.repo.ActivityLogRepo;
import com.example.assignment3.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {
    private ActivityLogRepo activityLogRepo;
    public ActivityLogServiceImpl(ActivityLogRepo activityLogRepo) {
        this.activityLogRepo =  activityLogRepo;
    }
    public void logActivity(Date date, String operation, long duration) {
        ActivityLog activity = new ActivityLog();
        activity.setDate(date);
        activity.setDuration(duration);
        activity.setOperation(operation);
        activityLogRepo.save(activity);
    }
}

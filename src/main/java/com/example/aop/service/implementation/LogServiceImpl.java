package com.example.aop.service.implementation;

import com.example.aop.entity.ActivityLog;
import com.example.aop.repository.ActivityLogRepo;
import com.example.aop.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    final ActivityLogRepo activityLogRepo;
    @Autowired
    public LogServiceImpl(ActivityLogRepo activityLogRepo) {
        this.activityLogRepo = activityLogRepo;
    }

    @Override
    public void savelog(ActivityLog activityLog) {
        this.activityLogRepo.save(activityLog);

    }
}

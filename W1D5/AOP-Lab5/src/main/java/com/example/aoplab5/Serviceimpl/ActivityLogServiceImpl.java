package com.example.aoplab5.Serviceimpl;

import com.example.aoplab5.Entity.ActivityLog;
import com.example.aoplab5.Repository.ActivityLogRepository;
import com.example.aoplab5.Service.ActivityLogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {

    private ActivityLogRepository activityLogRepository;

    @Override
    public void saveActivityLog(ActivityLog log) {
        activityLogRepository.save(log);
    }
}
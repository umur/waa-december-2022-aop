package com.example.AOP.Service.ServiceImpl;

import com.example.AOP.Entity.ActivityLog;
import com.example.AOP.Service.ActivityLogService;

import java.time.LocalDate;
import java.util.List;

public class ActivityLogServiceImpl implements ActivityLogService {
    @Override
    public void save(ActivityLog address) {

    }

    @Override
    public List<ActivityLog> getAll() {
        return null;
    }

    @Override
    public List<ActivityLog> findAllByDate(LocalDate date) {
        return null;
    }

    @Override
    public List<ActivityLog> findAllByDurationGreaterThan(long minDuration) {
        return null;
    }
}

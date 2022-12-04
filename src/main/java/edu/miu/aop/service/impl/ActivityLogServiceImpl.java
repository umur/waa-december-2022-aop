package edu.miu.aop.service.impl;

import edu.miu.aop.entity.ActivityLog;
import edu.miu.aop.repository.ActivityLogRepo;
import edu.miu.aop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {
    private final ActivityLogRepo activityLogRepo;

    @Override
    public void save(ActivityLog activityLog) {
        activityLogRepo.save(activityLog);
    }

}

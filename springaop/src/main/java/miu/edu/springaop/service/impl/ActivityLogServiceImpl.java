package miu.edu.springaop.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.springaop.entity.ActivityLog;
import miu.edu.springaop.repository.ActivityLogRepo;
import miu.edu.springaop.service.ActivityLogService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {
    private final ActivityLogRepo repo;

    @Override
    public void save(ActivityLog activityLog) {
        repo.save(activityLog);
    }
}

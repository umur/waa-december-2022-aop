package lab.com.aop.service.impl;

import lab.com.aop.entity.ActivityLog;
import lab.com.aop.repository.ActivityLogRepository;
import lab.com.aop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {
    public final ActivityLogRepository repo;
    @Override
    public void save(ActivityLog log) {
        repo.save(log);
    }
}

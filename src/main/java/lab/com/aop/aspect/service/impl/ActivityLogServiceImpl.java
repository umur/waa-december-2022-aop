package lab.com.aop.aspect.service.impl;

import lab.com.aop.aspect.entity.ActivityLog;
import lab.com.aop.aspect.repository.ActivityLogRepository;
import lab.com.aop.aspect.service.ActivityLogService;
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

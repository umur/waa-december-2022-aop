package edu.miu.lab5.annotation;

import edu.miu.lab5.model.ActivityLog;
import edu.miu.lab5.repo.ActivityLogRepo;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAOP {

    private final ActivityLogRepo activityLogRepo;

    @Pointcut("@annotation(edu.miu.lab5.annotation.ExecutionTime)")
    public void a(){}

    @Around("a()")
    public Object calculateExecutionTime(ProceedingJoinPoint p) throws Throwable{
        long startTime = System.nanoTime();
        Object result = p.proceed();
        long finishTime = System.nanoTime();
        long resultDuration = finishTime - startTime;

        ActivityLog activityLog = new ActivityLog();
        activityLog.setDate(LocalDateTime.now());
        activityLog.setDuration(resultDuration);
        activityLog.setOperation(p.getSignature().getName());
        activityLogRepo.save(activityLog);

        return result;
    }
}

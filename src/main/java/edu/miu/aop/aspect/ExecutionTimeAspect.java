package edu.miu.aop.aspect;

import edu.miu.aop.entity.ActivityLog;
import edu.miu.aop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Ankhbayar Azzaya
 */
@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {

    private final ActivityLogService activityLogService;

    @Pointcut("@annotation(edu.miu.aop.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {}

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();


        LocalDateTime dateTime = LocalDateTime.now();
        String operation = proceedingJoinPoint.getSignature().getName();
        long duration = finish - start;

        ActivityLog activityLog = new ActivityLog(dateTime, operation, duration);
        activityLogService.save(activityLog);

        System.out.println(operation);
        System.out.println(duration);
        return result;
    }
}

package miu.edu.springaop.aspect;

import lombok.RequiredArgsConstructor;
import miu.edu.springaop.entity.ActivityLog;
import miu.edu.springaop.service.ActivityLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {
    @Autowired
    private ActivityLogService logService;

    @Pointcut("@annotation(miu.edu.springaop.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {
    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();

        var result = proceedingJoinPoint.proceed();

        long finish = System.nanoTime();
        LocalDateTime dateTime = LocalDateTime.now();
        String operation = proceedingJoinPoint.getSignature().getName();
        long duration = finish - start;

        ActivityLog activityLog = new ActivityLog(dateTime, operation, duration);
        logService.save(activityLog);

        System.out.println(proceedingJoinPoint.getSignature().getName() + " takes ns: " + finish);
        return result;
    }

}

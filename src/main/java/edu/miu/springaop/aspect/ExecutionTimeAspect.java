package edu.miu.springaop.aspect;

import edu.miu.springaop.entity.ActivityLog;

import edu.miu.springaop.repository.ActivityLogRepo;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {
    final ActivityLogRepo activityRepo;
    @Pointcut("@annotation(edu.miu.springaop.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {
    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();

        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        var operation = proceedingJoinPoint.getSignature().getName();
        var   date = LocalDateTime.now();

        ActivityLog activityLog=new ActivityLog(
                date,
                operation,
                finish
        );
        this.activityRepo.save(activityLog);
        return result;
    }

}

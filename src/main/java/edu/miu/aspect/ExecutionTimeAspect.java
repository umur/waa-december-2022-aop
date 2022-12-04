package edu.miu.aspect;

import edu.miu.aspect.annotations.ExecutionTime;
import edu.miu.entity.ActivityLog;
import edu.miu.repository.ActivityLogRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {
    private final ActivityLogRepository logRepo;

    @Pointcut("@annotation(edu.miu.aspect.annotations.ExecutionTime)")

    public void executionTime() {
    }

    @Around("executionTime()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object proceed = joinPoint.proceed();
        long end = System.nanoTime();
        ActivityLog log = new ActivityLog();
        log.setOperation(joinPoint.getSignature().getName());
        log.setDuration(end - start);
        log.setDate(java.time.LocalDate.now());
        logRepo.save(log);

        return proceed;
    }
}

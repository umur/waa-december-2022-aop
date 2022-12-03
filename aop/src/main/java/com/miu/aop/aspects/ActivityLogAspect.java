package com.miu.aop.aspects;

import com.miu.aop.entities.dto.ActivityLogDto;
import com.miu.aop.services.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
@RequiredArgsConstructor
public class ActivityLogAspect {
    private final ActivityLogService activityLogService;

    @Pointcut("@annotation(com.miu.aop.aspects.annotations.ExecutionTime)")
    public void activityLogConcern(){ }

    @Around("activityLogConcern()")
    public Object activityLogJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        ActivityLogDto activityLogDto = new ActivityLogDto();

        activityLogDto.setDate(LocalDate.now());
        activityLogDto.setOperation(joinPoint.getSignature().getName());

        long start = System.nanoTime();
        var result = joinPoint.proceed();
        long end = System.nanoTime();

        activityLogDto.setDuration(end - start);

        activityLogService.save(activityLogDto);

        System.out.println(joinPoint.getSignature().getName() + " takes ns: " + (end - start));
        return result;
    }
}

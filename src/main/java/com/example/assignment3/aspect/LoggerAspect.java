package com.example.assignment3.aspect;

import com.example.assignment3.service.ActivityLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class LoggerAspect {
    private final ActivityLogService activityLogService;

    public LoggerAspect(ActivityLogService activityLogService) {
        this.activityLogService = activityLogService;
    }
    @Pointcut("@annotation(com.example.assignment3.aspect.annotation.Logger)")
    public void log() {
    }

    @Around("log()")
    public Object logging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        long totalTimeTaken = finish - start;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        activityLogService.logActivity(date, proceedingJoinPoint.getSignature().getName(), totalTimeTaken);
        return result;
    }
}

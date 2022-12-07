package com.example.aop.aspect;

import com.example.aop.entity.ActivityLog;
import com.example.aop.service.implementation.LogServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
public class ExecutionTimeAspect {

    final LogServiceImpl logger;
    @Autowired
    public ExecutionTimeAspect(LogServiceImpl logger) {
        this.logger = logger;
    }

    @Pointcut("@annotation(com.example.aop.aspect.annotation.ExecutionTime)")
    public void a(){

    }
    @Around("a()")
    public Object doExecute(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();

        var result = proceedingJoinPoint.proceed();

        long finish = System.nanoTime();

        ActivityLog a = new ActivityLog();
        a.setDate(LocalDate.now());
        a.setOperation(proceedingJoinPoint.getSignature().getName());
        a.setDuration(finish);
        this.logger.savelog(a);
      //  System.out.println(proceedingJoinPoint.getSignature().getName() + " takes ns: " + finish);
        return result;

    }
}

package edu.miu.aop.aspect;

import edu.miu.aop.entity.ActivityLog;
import edu.miu.aop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
public class LogAspect {

    private final ActivityLogService activityService;

    //define pointcut(WHICH)
    @Pointcut("@annotation(edu.miu.aop.aspect.annotation.ExecutionTime)")
    public void myAnnotation(){

    }

    //apply pointcut(WHEN)
    @Around("myAnnotation()")
    public Object logExecutionTime(ProceedingJoinPoint jp) throws Throwable {
        //create stopwatch object
        StopWatch sw = new StopWatch();
        sw.start(jp.getSignature().getName());
        var result = jp.proceed();
        sw.stop();

        long totalTime = sw.getLastTaskTimeMillis();

        //create ActivityLog object
        ActivityLog activityLog = new ActivityLog();
        activityLog.setDate(LocalDateTime.now());
        activityLog.setOperation(jp.getSignature().getName());
        activityLog.setDuration(totalTime);

        activityService.save(activityLog);
        return result;
    }

    @Before("execution(* edu.miu.aop.controller.*.*(..))")
    public void Before(JoinPoint jp){
        var args = jp.getArgs();
        var argList = "";
        for(int i = 0; i< args.length; i++){
            argList += "," + "arg"+ (i+1) + "=" + args[i];
        }
        if(argList.length() > 0)
            argList = "; arguments: " + argList.substring(1);

        System.out.println("REST API called. Controller: " + jp.getSignature().getDeclaringTypeName() +
                            "; method: " + jp.getSignature().getName() + argList);
    }
}

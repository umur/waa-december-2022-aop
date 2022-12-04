package miu.edu.waalab3aop.aspect;

import miu.edu.waalab3aop.entity.ActivityLog;
import miu.edu.waalab3aop.repository.ActivityLogRepo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;

@Aspect
@Component
public class ExecutionTimeAspect {
    @Autowired
    private ActivityLogRepo activityLogRepo;

    @Pointcut("@annotation(miu.edu.waalab3aop.annotation.ExecutionTime)")
    public void myExecution(){}

    @Around("myExecution()")
    public Object executionTime(ProceedingJoinPoint jp) throws Throwable {
       var start = System.nanoTime();
        var result = jp.proceed();
        System.out.println("System time difference :");
        var stop = System.nanoTime();
        var timeTaken = stop-start;
        activityLogRepo.save(new ActivityLog(LocalDate.now(),jp.getSignature().getName(),timeTaken));
        return result;
    }
}

package lab.com.aop.aspect;

import lab.com.aop.entity.ActivityLog;
import lab.com.aop.service.ActivityLogService;
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
public class ExecutionTimeAspect {
    public final ActivityLogService service;
    @Pointcut("@annotation(lab.com.aop.aspect.annotation.ExecutionTime)")
    public void a(){};


    @Around("a()")
    public Object calculateExecutionTime(ProceedingJoinPoint pjp) throws Throwable{

        long startTime = System.nanoTime();

        var result = pjp.proceed();

        long endTime = System.nanoTime();
        ActivityLog log = new ActivityLog(LocalDate.now(),pjp.getTarget().getClass().getSimpleName(),(endTime-startTime));

        service.save(log);
        return result;
    }

}

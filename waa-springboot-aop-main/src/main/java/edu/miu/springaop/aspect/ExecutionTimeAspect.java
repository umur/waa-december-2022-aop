package edu.miu.springaop.aspect;

import edu.miu.springaop.Dto.ActivityLogDto;
import edu.miu.springaop.Repository.ActivityLogRepo;
import edu.miu.springaop.Service.ActivityLogService;
import edu.miu.springaop.entity.ActivityLog;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Autowired
    private ActivityLogService activityLogService;

    @Pointcut("@annotation(edu.miu.springaop.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {
    }


    @Around("executionTimeAnnotation()")

    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        String methodName = proceedingJoinPoint.getSignature().toString();
        var result = proceedingJoinPoint.proceed();

        long finish = System.nanoTime();
        long duration = finish - start;

        ActivityLogDto activityLogDto = new ActivityLogDto(LocalDate.now(), methodName, duration);
        activityLogService.save(activityLogDto);

        System.out.println(proceedingJoinPoint.getSignature().getName() + " takes ns: " + finish);
        return result;
    }

}

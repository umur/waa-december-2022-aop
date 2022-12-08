package lab.com.aop.aspect.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Pointcut("@annotation(lab.com.aop.aspect.annotation.ExecutionTime)")
    public void a(){};


    @Around("a()")
    public Object calculateExecutionTime(ProceedingJoinPoint pjp) throws Throwable{

        long startTime = System.nanoTime();

        var result = pjp.proceed();

        long endTime = System.nanoTime();

        return result;
    }

}

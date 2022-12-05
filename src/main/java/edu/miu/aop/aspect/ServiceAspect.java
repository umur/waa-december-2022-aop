package edu.miu.aop.aspect;

import edu.miu.aop.exception.AopIsAwesomeHeaderException;
import edu.miu.aop.service.ActivityLogService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Ankhbayar Azzaya
 */
@Aspect
@Component
@RequiredArgsConstructor
public class ServiceAspect {
    private final HttpServletRequest request;

    @Pointcut("within(edu.miu.aop.service.Impl.*)")
    public void checkHeader() {}

    @Before("checkHeader()")
    public void headerJoinPoint(JoinPoint joinPoint) throws AopIsAwesomeHeaderException {
        System.out.println(request.getMethod() + " " + joinPoint.getSignature().getName());
        System.out.println("Header AOP-IS-AWESOME: " + request.getHeader("AOP-IS-AWESOME"));
        if (request.getMethod().equals("POST") && !request.getHeader("AOP-IS-AWESOME").isEmpty()) {
            throw new AopIsAwesomeHeaderException("Header AOP-IS-AWESOME is not present.");
        }
    }

}

package edu.miu.aspect;

import edu.miu.exception.AopIsAwesomeHeaderException;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPisAwesomeAspect {


    @Autowired
    HttpServletRequest request;


    @Before("within(edu.miu.service.*)")
    public void aroundAdvice(JoinPoint joinPoint) {
        if (request.getHeader("AOP-IS-AWESOME") == null) {
            throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME header is missing");
        }
    }
}

package com.miu.aop.aspects;

import com.miu.aop.Exceptions.AopIsAwesomeHeaderException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class AopIsAwesomeAspect {
    private final HttpServletRequest request;

    @Pointcut("execution(* com.miu.aop.services.*.*(..))")
    public void headerCheckPointCut(){}

    @Before("headerCheckPointCut()")
    public void aopIsAwesomeJoinPoint(JoinPoint jp){
        if(request.getMethod().equals("POST") && request.getHeader("AOP-IS-AWESOME") == null){
            throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME is required");
        }
    }

}

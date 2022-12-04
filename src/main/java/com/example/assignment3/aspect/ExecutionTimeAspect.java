package com.example.assignment3.aspect;

import com.example.assignment3.exception.AopIsAwesomeHeaderException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class ExecutionTimeAspect {
    private final HttpServletRequest request;

    public ExecutionTimeAspect(HttpServletRequest request) {
        this.request = request;
    }
    @Pointcut("@annotation(com.example.assignment3.aspect.annotation.ExecutionTime)")
    public void execute() {
    }

    @Before("execute()")
    public void executeMethod() throws Throwable{
        System.out.println("inside execute method");
        if(!Boolean.valueOf(request.getHeader("AOP-IS-AWESOME"))) {
            throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME header missing!");
        }
    }
}

package com.example.AOP.aspect;


import com.example.AOP.exceptions.AopIsAwesomeHeaderException;
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
public class CheckPostHeaderRequestAspect {

    private final HttpServletRequest request;
    @Pointcut("within(com.example.AOP.Controller.*)")
    public void checkPostHeaderRequest() {
    }

    @Before("checkPostHeaderRequest()")
    public void checkIfAopIsAwesomeHeaderException(JoinPoint joinPoint) {

        try {
            if (request.getMethod().equals("POST")) {
                if(request.getHeader("AOP-IS-AWESOME") == null)
                    throw new AopIsAwesomeHeaderException();
            }
        }
        catch(Exception e) {
            //System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
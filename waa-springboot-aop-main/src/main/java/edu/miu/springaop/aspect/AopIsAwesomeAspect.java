package edu.miu.springaop.aspect;


import edu.miu.springaop.Exception.AopIsAwesomeHeaderException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AopIsAwesomeAspect {
    @Autowired
    private HttpServletRequest request;


    @Around("execution(* edu.miu.springaop.Service.*.*(..))")
    public Object proceed(ProceedingJoinPoint joinPoint) throws Throwable{
        if (request.getMethod().equals("POST")) {
            var header = request.getHeader("AOP-IS-AWESOME");
            if (header != null) {
                return joinPoint.proceed();
            } else {
                throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME is required");
            }
        }
        return joinPoint.proceed();
    }


//@Before("execution(* edu.miu.springaop.Service.*.*(..))")
//public void aopIsAwesomeJoinPoint(JoinPoint jp){
//    if(request.getMethod().equals("POST") && request.getHeader("AOP-IS-AWESOME") == null){
//        throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME is required");
//    }
//}

}

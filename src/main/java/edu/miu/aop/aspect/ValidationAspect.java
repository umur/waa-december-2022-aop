package edu.miu.aop.aspect;

import edu.miu.aop.AopIsAweSomeHeaderException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Aspect
@Component
public class ValidationAspect {

    private final HttpServletRequest request;

    @Before("execution(* edu.miu.aop.service.*.*(..))")
    public void LogBefore(JoinPoint jp) throws AopIsAweSomeHeaderException {
        var aopHeader = request.getHeader("aop-is-awesome");
        if(aopHeader == null){
            throw new AopIsAweSomeHeaderException("AOP-IS-AWESOME header missing!");
        }
    }
}

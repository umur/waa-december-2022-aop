package miu.edu.springaop.aspect;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import miu.edu.springaop.exception.AopIsAwesomeHeaderException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Aspect
@Component
public class MyValidationAspect {
    private final HttpServletRequest request;

    @Pointcut("within(miu.edu.springaop.service.impl.*)")
    public void checkHeader() {}

    private String awesomeMsg = "AOP-IS-AWESOME";
    private String notPresentMsg = "Header AOP-IS-AWESOME is not found.";
    @Before("checkHeader()")
    public void headerJoinPoint(JoinPoint joinPoint) throws AopIsAwesomeHeaderException {

        if (request.getMethod().equals("POST") && !request.getHeader(awesomeMsg).isEmpty()) {
            throw new AopIsAwesomeHeaderException(notPresentMsg);
        }
    }
}

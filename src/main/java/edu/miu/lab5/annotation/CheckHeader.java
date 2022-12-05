package edu.miu.lab5.annotation;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class CheckHeader {
    private final HttpServletRequest httpServletRequest;

    @Pointcut("within(edu.miu.lab5.controller*)")
    public void a(){}

    @Before("a()")
    public void checkHeader() throws AopIsAwesome{
        if(!httpServletRequest.getMethod().equals("Post")) return;
        if(httpServletRequest.getHeader("AOP-IS-AWESOME") == null){
            throw new AopIsAwesome("AOP-IS-AWESOME is missing");
        }
    }
}

package com.example.aop.AOP.app;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class LogAspect {

    @Before("execution(* *(..))") //Pointcut
    public void logBefore(){ // Advice
        System.out.println("Method logg before");
    }
}

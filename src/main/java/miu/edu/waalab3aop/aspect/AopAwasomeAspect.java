package miu.edu.waalab3aop.aspect;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import miu.edu.waalab3aop.exception.AopIsAwesomeHeaderException;
import org.apache.coyote.Request;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Objects;

@Aspect
@Component
public class AopAwasomeAspect {
    @Autowired
    private HttpServletRequest httpServletRequest;

    @Pointcut("within(miu.edu.waalab3aop.service..*)")
    public void executeAopAwesome(){

    }
    @Before("executeAopAwesome()")
    public void executeAop(JoinPoint joinPoint) throws AopIsAwesomeHeaderException {
        String header = httpServletRequest.getHeader("AOP-IS-AWESOME");
        String method = httpServletRequest.getMethod();
        System.out.println("I am checking the incomming request is post and header isnot null :)");
        if(RequestMethod.POST.toString().equalsIgnoreCase(method) && Objects.isNull(header)){
            throw new AopIsAwesomeHeaderException("Aop is awesome is null in post request");
        }

    }
}

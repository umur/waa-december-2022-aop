package edu.miu.springaop.aspect;

import edu.miu.springaop.exception.AopIsAwesomeHeaderException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Aspect
@Component
public class PostServiceAspect {
    @Pointcut("within(edu.miu.springaop.service.*)")
    public void checkPost() {
    }

    @Before("checkPost()")
    public void check(JoinPoint joinPoint) throws AopIsAwesomeHeaderException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println("method type : "+request.getMethod());
        if(request.getMethod().equals("POST")){

            Enumeration<String> headerNames = request.getHeaderNames();
            if (headerNames != null) {
                while (headerNames.hasMoreElements()) {
                    if(request.getHeader(headerNames.nextElement()).equals("AOP-IS-AWESOME"))
                        return;
                }
            }
            throw new AopIsAwesomeHeaderException();
        }
    }
}

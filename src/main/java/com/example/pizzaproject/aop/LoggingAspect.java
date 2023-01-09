package com.example.pizzaproject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* com.example..*(..))")
    private void anyPublicMethod() {
    }

    @Before("anyPublicMethod()")
    public void beforeAnyPublicMethod(JoinPoint joinPoint) {
        log.info("invoke public method: " + joinPoint.getSignature().getName());
    }

    @Around("execution(* com.example.pizzaproject.controller..*(..))")
    public Object aroundControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object proceed = joinPoint.proceed();
        log.info(" :: Time: " + (System.nanoTime()-start) + "ns :: ");
        return proceed;

    }
}

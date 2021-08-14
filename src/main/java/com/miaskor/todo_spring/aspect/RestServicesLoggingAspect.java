package com.miaskor.todo_spring.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class RestServicesLoggingAspect {

    @Around("within(com.miaskor.todo_spring.service.*)")
    public Object findAllLog(ProceedingJoinPoint joinPoint) {
        var args = joinPoint.getArgs();
        if (args.length == 0) {
            log.info(joinPoint.getSignature().toLongString() + " method is started to execute");
        } else {
            log.info(joinPoint.getSignature().toLongString() + " method is started with parameter(s) "
                    + args[0].getClass() + " (" + args[0] + ")");
        }
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable e) {
            log.warn(e.getMessage() + " in " + joinPoint.getSignature().toLongString() + " method");
            throw new RuntimeException(e);
        }
        log.info(joinPoint.getSignature().toLongString() + " method is finished");
        return proceed;
    }
}

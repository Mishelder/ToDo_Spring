package com.miaskor.todo_spring.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ClientLoggingAspect {

    @Around("execution(public java.util.Set com.miaskor.todo_spring.service.ClientServiceImpl.findAll())")
    public Object findAllLog(ProceedingJoinPoint joinPoint){
        log.info("findAll() clients method is started to execute");
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        }catch (Throwable e){
            log.warn(e.getMessage() + " in findAll() clients method");
            throw new RuntimeException(e);
        }
        log.info("findAll() clients method is finished");
        return proceed;
    }

    @Around("execution(public com.miaskor.todo_spring.model.Client" +
            " com.miaskor.todo_spring.service.ClientServiceImpl.findById(Integer))")
    public Object findByIdLog(ProceedingJoinPoint joinPoint){
        var args = joinPoint.getArgs();
        log.info("findById() client method is started with parameter(s) "
                + args[0].getClass() + " (" + args[0]+")");
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable e) {
            log.warn(e.getMessage() + " in findById() client method");
            throw new RuntimeException(e);
        }
        log.info("findById() client method is finished");
        return proceed;
    }

    @Around("execution (public com.miaskor.todo_spring.model.Client" +
            " com.miaskor.todo_spring.service.ClientServiceImpl.save(com.miaskor.todo_spring.model.Client))")
    public Object saveLog(ProceedingJoinPoint joinPoint){
        var args = joinPoint.getArgs();
        log.info("save() client method is started with parameter(s) "
                + args[0].getClass() + " (" + args[0]+")");
        Object proceed = null;
        try{
            proceed = joinPoint.proceed();
        }catch (Throwable e){
            log.warn(e.getMessage() + " client couldn't saved");
            throw new RuntimeException(e);
        }
        log.info("save() client method is finished with returning type " + proceed);
        return proceed;
    }

    @Around("execution (public void" +
            " com.miaskor.todo_spring.service.ClientServiceImpl.delete(com.miaskor.todo_spring.model.Client))")
    public Object deleteLog(ProceedingJoinPoint joinPoint){
        var args = joinPoint.getArgs();
        log.info("delete() client method is started with parameter(s) "
                + args[0].getClass() + " (" + args[0]+")");
        Object proceed = null;
        try{
            proceed = joinPoint.proceed();
        }catch (Throwable e){
            log.warn(e.getMessage() + " client couldn't deleted");
            throw new RuntimeException(e);
        }
        log.info("delete() client method is finished");
        return proceed;
    }

    @Around("execution (public void" +
            " com.miaskor.todo_spring.service.ClientServiceImpl.deleteById(Integer))")
    public Object deleteByIdLog(ProceedingJoinPoint joinPoint){
        var args = joinPoint.getArgs();
        log.info("deleteById() client method is started with parameter(s) "
                + args[0].getClass() + " (" + args[0]+")");
        Object proceed = null;
        try{
            proceed = joinPoint.proceed();
        }catch (Throwable e){
            log.warn(e.getMessage() + " client couldn't deleted");
            throw new RuntimeException(e);
        }
        log.info("deleteById() client method is finished");
        return proceed;
    }
}

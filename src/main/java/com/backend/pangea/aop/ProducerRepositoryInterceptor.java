package com.backend.pangea.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@EnableAspectJAutoProxy
@Component
public class ProducerRepositoryInterceptor {
    
    @Pointcut("execution(* com..ProducerRepositoryService.save(..))")
    public void saveInterceptor() { }


        
}

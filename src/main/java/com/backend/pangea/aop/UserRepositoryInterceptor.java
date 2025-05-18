package com.backend.pangea.aop;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.backend.pangea.entity.Administrators;
import com.backend.pangea.entity.Consumers;
import com.backend.pangea.entity.Producers;
import com.backend.pangea.entity.Users;
import com.backend.pangea.services.AdministratorRepositoryService;
import com.backend.pangea.services.ConsumerRepositoryService;
import com.backend.pangea.services.ProducerRepositoryService;

@Component
@EnableAspectJAutoProxy
@Aspect
public class UserRepositoryInterceptor {

    private final AdministratorRepositoryService administratorRepositoryService;
    private final ConsumerRepositoryService consumerRepositoryService;
    private final ProducerRepositoryService producerRepositoryService;

    public UserRepositoryInterceptor(
            final AdministratorRepositoryService administratorRepositoryService,
            final ConsumerRepositoryService consumerRepositoryService,
            final ProducerRepositoryService producerRepositoryService
    ) {
        this.administratorRepositoryService = administratorRepositoryService;
        this.consumerRepositoryService = consumerRepositoryService;
        this.producerRepositoryService = producerRepositoryService;
    }

    @Pointcut("execution(* com..UserRepositoryService.save(..))")
    public void saveInterceptor() {}

    @Pointcut("execution(* com..UserRepositoryService.update(..))")
    public void updateInterceptor() {}

    /**
     * Después de que un usuario es almacenado, si continene algún rol, añadir ese rol!
     * @param entity
     */
    @AfterReturning(value = "saveInterceptor()", returning = "entity")
    public void saveSuccessfully(Users entity) {

        Administrators administrator = entity.getAdministrator();
        Producers producer = entity.getProducer();
        Consumers consumer = entity.getConsumer();

        if (administrator != null) {
            administrator.setUser(entity);
            administratorRepositoryService.save(administrator);
        }
        
        if (producer != null) {
            producer.setUser(entity);
            producerRepositoryService.save(producer);
        }
        
        if (consumer != null) {
            consumer.setUser(entity);
            consumerRepositoryService.save(consumer);
        }
    }
}

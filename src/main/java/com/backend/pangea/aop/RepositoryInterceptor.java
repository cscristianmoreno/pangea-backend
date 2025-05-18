package com.backend.pangea.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.backend.pangea.entity.Users;
import com.backend.pangea.exceptions.RepositoryException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Aspect
@EnableAspectJAutoProxy
public class RepositoryInterceptor {

    @Autowired
    private ObjectMapper objectMapper;
    
    @Pointcut("execution(* com..*RepositoryService.update(..))")
    public void updateInterceptor() {}

    /**
     * Verifica que el método UPDATE no tenga el ID vacío ya que, si es así, se inserataría un nuevo valor
     * @param joinPoint
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    @Before("updateInterceptor()")
    public void verifyUpdateIdIsNotNull(JoinPoint joinPoint) throws JsonMappingException, JsonProcessingException {

        Object param = joinPoint.getArgs()[0];
        String json = objectMapper.writeValueAsString(param);
        JsonNode jsonNode = objectMapper.readTree(json);

        int id = jsonNode.get("id").asInt();

        if (id == 0) {
            throw new RepositoryException("El campo ID es requerido");
        }
    }
}

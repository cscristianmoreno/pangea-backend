package com.backend.pangea.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.backend.pangea.dto.HttpResponseEntity;
import com.backend.pangea.utils.HttpResponseEntityUtil;

@ControllerAdvice
public class HttpExceptions {
    @ExceptionHandler(value = DataIntegrityViolationException.class) 
    public ResponseEntity<HttpResponseEntity<Object>> dataIntegrityViolationException(final Exception exception) {
        return HttpResponseEntityUtil.unauthorized("El nombre del municipio ya está registrado");
    }

    @ExceptionHandler(value = {Exception.class}) 
    public ResponseEntity<HttpResponseEntity<Object>> exceptions(final Exception exception) {
        return HttpResponseEntityUtil.unauthorized(exception.getMessage());
    }
}

package com.backend.pangea.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.backend.pangea.dto.HttpResponseEntity;

public abstract class HttpResponseEntityUtil  {
    public static <T> ResponseEntity<HttpResponseEntity<T>> ok(T body) {
        return sendMessage(body, HttpStatus.OK);
    }

    public static ResponseEntity<HttpResponseEntity<Object>> unauthorized(String message) {
        return sendMessage(message, HttpStatus.UNAUTHORIZED);
    }

    private static <T> ResponseEntity<HttpResponseEntity<T>> sendMessage(T result, HttpStatus status) {
        HttpResponseEntity<T> response = new HttpResponseEntity<>();
        response.setResult(result);
        response.setStatus(status);
        return new ResponseEntity<HttpResponseEntity<T>>(response, status);
    }
}

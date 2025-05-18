package com.backend.pangea.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.backend.pangea.dto.HttpResponseEntity;

public abstract class HttpResponseEntityUtil  {
    public static <T> ResponseEntity<HttpResponseEntity<T>> ok(T body) {
        return sendMessage(body, HttpStatus.OK);
    }

    public static <T> ResponseEntity<HttpResponseEntity<T>> unauthorized(String message) {
        return sendMessage((T) message, HttpStatus.UNAUTHORIZED);
    }

    private static <T> ResponseEntity<HttpResponseEntity<T>> sendMessage(T result, HttpStatus status) {
        HttpResponseEntity<T> response = new HttpResponseEntity<>();
        response.setResult(result);
        response.setStatus(HttpStatus.OK);
        return new ResponseEntity<HttpResponseEntity<T>>(response, status);
    }
}

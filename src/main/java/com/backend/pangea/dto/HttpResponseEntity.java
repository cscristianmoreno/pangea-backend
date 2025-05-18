package com.backend.pangea.dto;

import org.springframework.http.HttpStatus;

public class HttpResponseEntity<T> {
    private HttpStatus status;
    private T result;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }
    
    public void setResult(T result) {
        this.result = result;
    }
}

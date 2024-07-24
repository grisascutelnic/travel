package com.application.travel_web_app.exceptions;

import org.springframework.http.HttpStatus;

public class AlreadyExistException extends RuntimeException{
    private String message;
    private HttpStatus status = HttpStatus.CONFLICT;

    public AlreadyExistException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
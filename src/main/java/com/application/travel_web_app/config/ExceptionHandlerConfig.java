package com.application.travel_web_app.config;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import com.application.travel_web_app.exceptions.AlreadyExistError;
import com.application.travel_web_app.exceptions.NotFoundError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerConfig {

    @ExceptionHandler(NotFoundError.class)
    private ResponseEntity<Object> notFoundException(NotFoundError notFoundException) {
        Map<String, String> map = new HashMap<>();

        map.put("timestamp", Instant.now().toString());
        map.put("message", notFoundException.getMessage());
        map.put("status", notFoundException.getStatus().toString());

        return ResponseEntity.status(notFoundException.getStatus()).body(map);
    }

    @ExceptionHandler(AlreadyExistError.class)
    private ResponseEntity<Object> alreadyExistException(AlreadyExistError alreadyExistException) {
        Map<String, String> map = new HashMap<>();

        map.put("timestamp", Instant.now().toString());
        map.put("message", alreadyExistException.getMessage());
        map.put("status", alreadyExistException.getStatus().toString());

        return ResponseEntity.status(alreadyExistException.getStatus()).body(map);
    }
}
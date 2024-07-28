package com.application.travel_web_app.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AlreadyExistException extends RuntimeException{
    private String message;
    private HttpStatus status = HttpStatus.CONFLICT;
}